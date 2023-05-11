package com.ravikiran.schoolpaymentpage.common

internal class NoDefintionFoundException : Throwable(EXCEPTION_MESSAGE) {
    companion object {
        const val EXCEPTION_MESSAGE = "No definition of the function found in the implementing sub class."
    }
}