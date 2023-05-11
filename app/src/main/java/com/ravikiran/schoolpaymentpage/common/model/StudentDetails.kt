package com.ravikiran.schoolpaymentpage.common.model


import com.google.gson.annotations.SerializedName

data class StudentDetails(
    @SerializedName("AcademicYearID")
    val academicYearID: String?,
    @SerializedName("ActualAmount")
    val actualAmount: Any?,
    @SerializedName("AdmissionNumber")
    val admissionNumber: String?,
    @SerializedName("AnualFee")
    val anualFee: String?,
    @SerializedName("Balance")
    val balance: Any?,
    @SerializedName("ClassID")
    val classID: String?,
    @SerializedName("ClassName")
    val className: String?,
    @SerializedName("Corr_Mobile")
    val corrMobile: String?,
    @SerializedName("DOB")
    val dOB: String?,
    @SerializedName("DOJ")
    val dOJ: String?,
    @SerializedName("Discount")
    val discount: String?,
    @SerializedName("DiscountAmount")
    val discountAmount: String?,
    @SerializedName("FatherName")
    val fatherName: String?,
    @SerializedName("FeeAmount")
    val feeAmount: String?,
    @SerializedName("Groups")
    val groups: String?,
    @SerializedName("isNoPay")
    val isNoPay: String?,
    @SerializedName("isPastDateEnable")
    val isPastDateEnable: Int?,
    @SerializedName("isRoleDiscount")
    val isRoleDiscount: Int?,
    @SerializedName("IsTermDiscount")
    val isTermDiscount: String?,
    @SerializedName("IsTermEnabled")
    val isTermEnabled: Boolean?,
    @SerializedName("LastPaidDate")
    val lastPaidDate: String?,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("Paid")
    val paid: String?,
    @SerializedName("ParentType")
    val parentType: String?,
    @SerializedName("Photo")
    val photo: String?,
    @SerializedName("Remarks")
    val remarks: String?,
    @SerializedName("RollNumber")
    val rollNumber: Int?,
    @SerializedName("RouteName")
    val routeName: String?,
    @SerializedName("SchoolID")
    val schoolID: String?,
    @SerializedName("SectionID")
    val sectionID: String?,
    @SerializedName("SectionName")
    val sectionName: Any?,
    @SerializedName("StudentID")
    val studentID: String?
)