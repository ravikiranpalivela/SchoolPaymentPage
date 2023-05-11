package com.ravikiran.schoolpaymentpage.common.model


import com.google.gson.annotations.SerializedName

data class SpecialFees(
    @SerializedName("FeeAmount")
    val feeAmount: String?,
    @SerializedName("FeeName")
    val feeName: String?,
    @SerializedName("FeeStructureID")
    val feeStructureID: String?,
    @SerializedName("FeeTypeID")
    val feeTypeID: String?,
    @SerializedName("IsPaid")
    val isPaid: String?,
    @SerializedName("PendingTransaction")
    val pendingTransaction: String?,
    @SerializedName("StudentID")
    val studentID: String?
)