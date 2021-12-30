package com.example.buscarendereo.domain.repository

import com.example.buscarendereo.domain.network.Endereco

interface GetCepInformationRepository {
    suspend fun getCepInformation(cep: String): Endereco
}