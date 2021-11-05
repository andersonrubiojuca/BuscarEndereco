package com.example.buscarendereo.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class EnderecoApplication: KoinComponent {
    val enderecoServiceInt by inject<EnderecoServiceInt> ()

    fun sayEnde() = enderecoServiceInt.ende()
}