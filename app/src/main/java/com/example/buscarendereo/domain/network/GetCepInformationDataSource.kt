package com.example.buscarendereo.domain.network

class GetCepInformationDataSource(private val service: EnderecoService) {
    suspend fun getCepInformation(cep: String): Endereco {
        return try {
            service.getJson(cep)
        } catch (e: Throwable){
            throw e
        }
    }
}