package com.ravikiran.schoolpaymentpage

import android.app.Application
import com.ravikiran.schoolpaymentpage.common.CTConfig
import com.ravikiran.schoolpaymentpage.common.ConfigProvider


class CTApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ConfigProvider.setConfiguration(
                CTConfig(
                        this,
                    "http://stageapi.iguru.guru:222/api/Payment/"
                )
        )
    }
}