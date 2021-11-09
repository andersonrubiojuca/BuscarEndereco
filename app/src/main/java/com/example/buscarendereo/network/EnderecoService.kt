package com.example.buscarendereo.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://viacep.com.br/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private var retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface EnderecoService {

    @GET("ws/{valor}/json")
    suspend fun getJson(@Path("valor")valor :String): Endereco
}

object EnderecoApi{
    val retrofitService: EnderecoService by lazy { retrofit.create(EnderecoService::class.java) }
}