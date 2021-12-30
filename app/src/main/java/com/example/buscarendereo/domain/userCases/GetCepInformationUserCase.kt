package com.example.buscarendereo.domain.userCases

import com.example.buscarendereo.domain.network.Endereco
import com.example.buscarendereo.domain.repository.GetCepInformationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCepInformationUserCase(private val repository: GetCepInformationRepository) {
    suspend operator fun invoke(cep: String): Endereco{
        return withContext(Dispatchers.IO){
            repository.getCepInformation(cep)
        }
    }
}