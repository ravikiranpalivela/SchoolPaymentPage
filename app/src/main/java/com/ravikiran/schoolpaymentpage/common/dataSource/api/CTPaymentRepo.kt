package com.ravikiran.schoolpaymentpage.common.dataSource.api

import com.google.gson.JsonObject
import com.ravikiran.schoolpaymentpage.common.CTConfig
import com.ravikiran.schoolpaymentpage.data.ApiCallback
import com.ravikiran.schoolpaymentpage.data.remote.CTRetrofitDataSource

class CTPaymentRepo(config: CTConfig) : PaymentRemoteSource {

    private var retrofitDs = CTRetrofitDataSource(config)

    override fun checkPaymentDetails(callback: ApiCallback)  {
        retrofitDs.checkPaymentDetails(callback)
    }
}