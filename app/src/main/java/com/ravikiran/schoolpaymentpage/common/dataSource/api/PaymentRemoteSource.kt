package com.ravikiran.schoolpaymentpage.common.dataSource.api

import com.google.gson.JsonObject
import com.ravikiran.schoolpaymentpage.common.NoDefintionFoundException
import com.ravikiran.schoolpaymentpage.data.ApiCallback

interface PaymentRemoteSource {

    fun checkPaymentDetails(callback: ApiCallback) {
        throw NoDefintionFoundException()
    }
}