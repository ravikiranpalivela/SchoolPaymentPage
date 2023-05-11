package com.ravikiran.schoolpaymentpage.common.model


import com.google.gson.annotations.SerializedName

data class PaymentDetails(
    @SerializedName("Message")
    val message: String?,
    @SerializedName("ResponseCode")
    val responseCode: Int?,
    @SerializedName("Response")
    val responseData: ResponseData?
)