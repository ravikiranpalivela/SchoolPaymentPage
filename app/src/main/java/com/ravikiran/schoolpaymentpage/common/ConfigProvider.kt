package com.ravikiran.schoolpaymentpage.common

object ConfigProvider {

    private var configuration: CTConfig? = null

    fun setConfiguration(config: CTConfig) {
        configuration = config
    }

    fun getConfiguration() = configuration ?: throw IllegalStateException("You must initialize the configuration")
}