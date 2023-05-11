package com.ravikiran.schoolpaymentpage.common.model


import com.google.gson.annotations.SerializedName

class BodyData : ArrayList<BodyDataItem>(){
        fun toMap(): MutableMap<String, Any> = mutableMapOf(
            "Model" to BodyDataItem()
        )
}