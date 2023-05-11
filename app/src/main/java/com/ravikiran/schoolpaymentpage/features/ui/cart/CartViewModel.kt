package com.ravikiran.schoolpaymentpage.features.ui.cart

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.google.gson.JsonObject
import com.ravikiran.schoolpaymentpage.common.CTBaseViewModel
import com.ravikiran.schoolpaymentpage.common.ConfigProvider
import com.ravikiran.schoolpaymentpage.common.dataSource.api.CTPaymentRepo
import com.ravikiran.schoolpaymentpage.common.model.FeeMasterdata
import com.ravikiran.schoolpaymentpage.common.model.PaymentDetails
import com.ravikiran.schoolpaymentpage.common.model.StudentDetails
import com.ravikiran.schoolpaymentpage.data.ApiCallback
import kotlinx.coroutines.launch

class CartViewModel(app: Application) : CTBaseViewModel(app) {

    private val loginRepo = CTPaymentRepo(ConfigProvider.getConfiguration())

    private val _cartItems = MutableLiveData<List<FeeMasterdata?>>()
    val cartItems: LiveData<List<FeeMasterdata?>> get() = _cartItems

    private val _studentDetails = MutableLiveData<StudentDetails?>()
    val studentDetails: LiveData<StudentDetails?> get() = _studentDetails


    val totalPrice: LiveData<Double> = Transformations.map(cartItems) { items ->
        items.sumOf {
            it?.amountValue!! * 1
        }
    }

    init {
        getCartItems()
    }

    fun getCartItems() {
        Log.d("TAG","getCart")
                loginRepo.checkPaymentDetails(object : ApiCallback {
                    override fun onSuccess(response: PaymentDetails) {
                        response.responseData?.let {
                            it.listFeeMasterdata.let { feeList->
                                _cartItems.value = feeList
                                Log.d("TAG", "onSuccess: ${feeList.toString()}")
                            }
                            it.listStudentDetails?.let { feeList->
                                _studentDetails.value = feeList[0]
                                Log.d("TAG", "onSuccess: ${feeList.toString()}")
                            }
                        }
                    }

                    override fun onFailure(errorMsg: String) {
//                        passwordError.value = errorMsg
//                        showProgress.value = false
                    }
                })
    }

    fun setCartItems(items: List<FeeMasterdata>) {
        _cartItems.value = items
    }

    fun updateCartItemPrice(item: FeeMasterdata, newPrice: Double) {
        val items = _cartItems.value ?: return
        val updatedItems = items.map {
            if (it?.feestructureId == item.feestructureId) {
                it
            } else {
                it
            }
        }
        _cartItems.value = updatedItems
    }

    fun toggleCartItemChecked(item: FeeMasterdata) {
        val items = _cartItems.value ?: return
        val updatedItems = items.map {
            if (it?.feestructureId == item.feestructureId) {
                it?.copy(isChecked = !it.isChecked!!)
            } else {
                it
            }
        }
        _cartItems.value = updatedItems
    }

    fun updateCart()
    {

    }

    fun getTotalAmount(): String {
        var totalAmount = 0.0
        val cartList = cartItems.value ?: ArrayList()
        for (product in cartList) {
            totalAmount += product?.totalFeeAmount?.toDouble()!!
        }
        return totalAmount.toString()
    }
}
