package com.example.buscarendereo.di

import com.example.buscarendereo.network.Endereco

interface EnderecoServiceInt {
    fun ende(): Endereco
}

class EnderecoServiceImpl(private val enderecoData: Endereco): EnderecoServiceInt{
    override fun ende(): Endereco {
        return enderecoData
    }

}