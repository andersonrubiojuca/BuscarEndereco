package com.example.buscarendereo.domain.network

import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoService {
    @GET("ws/{valor}/json")
    suspend fun getJson(@Path("valor")valor :String): Endereco
}