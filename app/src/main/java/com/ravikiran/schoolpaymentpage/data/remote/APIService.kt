package com.ravikiran.schoolpaymentpage.data.remote

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.ravikiran.schoolpaymentpage.common.model.BodyData
import com.ravikiran.schoolpaymentpage.common.model.PaymentDetails
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

internal interface APIService {

    @GET("GetFeeStudentDetails")
    fun checkPaymentDetails(@Query("model") data : String): Call<PaymentDetails>
}