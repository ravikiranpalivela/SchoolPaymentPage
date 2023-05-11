package com.ravikiran.schoolpaymentpage.data.remote

import android.util.Log
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.ravikiran.schoolpaymentpage.common.CTConfig
import com.ravikiran.schoolpaymentpage.common.dataSource.api.PaymentRemoteSource
import com.ravikiran.schoolpaymentpage.common.model.BodyData
import com.ravikiran.schoolpaymentpage.common.model.BodyDataItem
import com.ravikiran.schoolpaymentpage.common.model.PaymentDetails
import com.ravikiran.schoolpaymentpage.data.ApiCallback
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.ConnectException
import java.net.UnknownHostException


class CTRetrofitDataSource(config: CTConfig) : PaymentRemoteSource {

    private var apiService = RetrofitHelper(config).getApiService()

    override fun checkPaymentDetails(callback: ApiCallback) {
        Log.d("TAG","checkPaymentDetails")


        val jsonObject = JSONObject()
        var requestData = JsonObject()
        val jsonArray = JSONArray()

        try {
            jsonObject.put("StudentID","68856")
            jsonObject.put("Section_ID","")
            jsonObject.put("Class_ID","")
            jsonObject.put("AcademicYearID","8")
            jsonObject.put("SchoolID","286")
            jsonArray.put(jsonObject)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        apiService.checkPaymentDetails(jsonArray.toString()).enqueue(object : Callback<PaymentDetails> {
            override fun onFailure(call: Call<PaymentDetails>, t: Throwable) {
                callback.onFailure(processApiFailure(t))
            }

            override fun onResponse(call: Call<PaymentDetails>, response: Response<PaymentDetails>) {
                Log.d("TAG","Response ${response.body()} ${ response}")
                if (response.code() == 200) {
                    response.body()?.let {
                        callback.onSuccess(it)
                        return
                    }
                    callback.onFailure(SOMETHING_WENT_WRONG)
                } else {
                    response.errorBody()?.string()?.let {
                        Log.e(TAG, it)
                        JSONObject(it).let { errorJson ->
                            callback.onFailure(errorJson.optString("message", SOMETHING_WENT_WRONG))
                            return
                        }
                    }
                    callback.onFailure(SOMETHING_WENT_WRONG)
                }
            }




        })
    }



    /**
     * prepares the appropriate error message to be handled to the View
     *
     * @param presenterName to log where the error occurred
     * @param throwable     the Throwable
     */
    private fun processApiFailure(throwable: Throwable?): String {

        var errorMessage = SOMETHING_WENT_WRONG

        if (throwable?.message != null) {
            Log.e(TAG, "API error : ${throwable.localizedMessage}")
            if (throwable is ConnectException) {
                errorMessage = CHECK_INTERNET_MSG

            } else if (throwable is UnknownHostException) {
                errorMessage = SOMETHING_WENT_WRONG
            }
        }

        return errorMessage
    }

    companion object {
        private val TAG = CTRetrofitDataSource::class.java.simpleName
        internal const val SOMETHING_WENT_WRONG = "Something went wrong. Please try after sometime."
        internal const val CHECK_INTERNET_MSG = "Please check your network connectivity"
    }
}