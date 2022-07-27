package com.e1ko0o.android.simplewordlearner

import com.e1ko0o.android.simplewordlearner.models.Word
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MainService {
    @GET("words/{word}") // https://habr.com/ru/post/568792/
    suspend fun getWord(@Path("word") word : String) : Response<Word>
}