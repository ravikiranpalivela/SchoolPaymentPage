package com.ravikiran.schoolpaymentpage.common.model


import com.google.gson.annotations.SerializedName

data class TotalSummeryList(
    @SerializedName("TotalBalance")
    val totalBalance: Double?,
    @SerializedName("TotalDiscount")
    val totalDiscount: Double?,
    @SerializedName("TotalFeeAmount")
    val totalFeeAmount: Double?,
    @SerializedName("TotalPaidAmount")
    val totalPaidAmount: Double?
)