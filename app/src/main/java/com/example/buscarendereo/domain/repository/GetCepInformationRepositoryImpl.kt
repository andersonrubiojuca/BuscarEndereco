package com.example.buscarendereo.domain.repository

import com.example.buscarendereo.domain.network.Endereco
import com.example.buscarendereo.domain.network.GetCepInformationDataSource

class GetCepInformationRepositoryImpl(private val dataSource: GetCepInformationDataSource):
    GetCepInformationRepository {

    override suspend fun getCepInformation(cep: String): Endereco {
        return dataSource.getCepInformation(cep)
    }
}