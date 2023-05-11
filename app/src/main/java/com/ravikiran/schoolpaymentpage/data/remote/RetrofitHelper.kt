package com.ravikiran.schoolpaymentpage.data.remote


//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor

import com.google.gson.GsonBuilder
import com.ravikiran.schoolpaymentpage.common.CTConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal class RetrofitHelper(private val config: CTConfig) {

    private lateinit var apiService: APIService

    var gson = GsonBuilder()
        .setLenient()
        .create()

    fun getApiService(): APIService {
        // Initialize ApiService if not initialized yet
        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(config.serverUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            apiService = retrofit.create(APIService::class.java)
        }
        return apiService
    }

//    fun getApiService(): APIService {
//        return Retrofit.Builder()
//            .baseUrl(config.serverUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(getRequestResponseInterceptor())
//            .build()
//            .create(APIService::class.java)
//    }
//
//    /**
//     * Custom Response Interceptor client that intercepts the service calls and provides insights into
//     * every different processes taking place.
//     *
//     * This method is used for the following use cases:
//     *      -> Intercepting the key-value pairs in the data.
//     *      -> Intercepting the response body of the service call.
//     *      -> Intercepting the download progress of data being downloaded.
//     *
//     * Returns customized [OkHttpClient] object.
//     */
//    private fun getRequestResponseInterceptor(): OkHttpClient {
//
//        val httpClient: OkHttpClient.Builder = OkHttpClient().newBuilder()
//        val logging = HttpLoggingInterceptor()
//
//        logging.level = HttpLoggingInterceptor.Level.BODY
//        httpClient.interceptors().add(logging)
//        httpClient.connectTimeout(20, TimeUnit.SECONDS)
//        httpClient.writeTimeout(0, TimeUnit.SECONDS)
//        httpClient.readTimeout(5, TimeUnit.MINUTES)
//        return httpClient.build()
//    }

    companion object {
        private val TAG = RetrofitHelper::class.java.simpleName
    }
}