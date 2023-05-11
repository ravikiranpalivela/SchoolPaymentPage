package com.ravikiran.schoolpaymentpage.common.model


import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("listFeeMasterdata")
    val listFeeMasterdata: List<FeeMasterdata?>?,
    @SerializedName("listSpecialFees")
    val listSpecialFees: List<SpecialFees?>?,
    @SerializedName("listStudentDetails")
    val listStudentDetails: List<StudentDetails?>?,
    @SerializedName("listStudentsiblings")
    val listStudentsiblings: List<Any?>?,
    @SerializedName("TotalSummeryList")
    val totalSummeryList: TotalSummeryList?
)