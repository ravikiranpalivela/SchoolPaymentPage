package com.ravikiran.schoolpaymentpage.data

import com.google.gson.JsonObject
import com.ravikiran.schoolpaymentpage.common.model.PaymentDetails

interface ApiCallback {
    fun onSuccess(response: PaymentDetails)
    fun onFailure(errorMsg: String)
}