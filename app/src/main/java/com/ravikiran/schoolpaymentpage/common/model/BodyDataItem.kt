package com.ravikiran.schoolpaymentpage.common.model


import com.google.gson.annotations.SerializedName

data class BodyDataItem(
    @SerializedName("AcademicYearID")
    val academicYearID: String? = "8",
    @SerializedName("Class_ID")
    val classID: String?="",
    @SerializedName("SchoolID")
    val schoolID: String?="286",
    @SerializedName("Section_ID")
    val sectionID: String?= "",
    @SerializedName("StudentID")
    val studentID: String? = "68856"
)
{
    fun toMap(): MutableMap<String, String?> = mutableMapOf(
        "AcademicYearID" to academicYearID,
        "Class_ID" to classID,
        "SchoolID" to schoolID,
        "Section_ID" to sectionID,
        "StudentID" to studentID
    )
}