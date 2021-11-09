package com.example.buscarendereo.di

import com.example.buscarendereo.network.Endereco

interface EnderecoRepository {
    fun ende(): Endereco
}

class EnderecoServiceImpl(val enderecoData: Endereco): EnderecoRepository{
    override fun ende(): Endereco {
        return enderecoData
    }

}