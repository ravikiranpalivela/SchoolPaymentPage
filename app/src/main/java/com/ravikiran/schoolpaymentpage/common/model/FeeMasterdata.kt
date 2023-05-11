package com.ravikiran.schoolpaymentpage.common.model


import com.google.gson.annotations.SerializedName

data class FeeMasterdata(
    @SerializedName("Balance")
    var balance: String?,
    @SerializedName("Discount")
    var discount: String?,
    @SerializedName("EnvFlag")
    var envFlag: String?,
    @SerializedName("FeeAmount")
    var feeAmount: String?,
    @SerializedName("FeeStructureField")
    var feeStructureField: String?,
    @SerializedName("FeeType")
    var feeType: String?,
    @SerializedName("FeestructureId")
    var feestructureId: String?,
    @SerializedName("GatewayName")
    var gatewayName: String?,
    @SerializedName("GatewayUrl")
    var gatewayUrl: String?,
    @SerializedName("iOSMID")
    var iOSMID: String?,
    @SerializedName("iOSMerchantKey")
    var iOSMerchantKey: String?,
    @SerializedName("IsChecked")
    var isChecked: Boolean?,
    @SerializedName("IsDeductable")
    var isDeductable: String?,
    @SerializedName("IsEditable")
    var isEditable: Boolean?,
    @SerializedName("IsEnabled")
    var isEnabled: Boolean?,
    @SerializedName("IsExist")
    var isExist: String?,
    @SerializedName("isRebate")
    var isRebate: Int?,
    @SerializedName("Latefee")
    var latefee: String?,
    @SerializedName("MID")
    var mID: String?,
    @SerializedName("MerchantKey")
    var merchantKey: String?,
    @SerializedName("MerchantName")
    var merchantName: String?,
    @SerializedName("PaidAmount")
    var paidAmount: String?,
    @SerializedName("PaymentModeId")
    var paymentModeId: String?,
    @SerializedName("PendingTransaction")
    var pendingTransaction: String?,
    @SerializedName("TotalFeeAmount")
    var totalFeeAmount: String?,
    @SerializedName("AmountValue")
    var amountValue: Double?
)