package com.example.buscarendereo.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Endereco (
    val cep: String = "",
    val logradouro: String = "",
    val complemento: String = "",
    val bairro: String = "",
    val localidade: String = "",
    val uf: String = "",
    val ibge: String = "",
    val gia: String = "",
    val ddd: String = "",
    val siafi: String = ""
        ): Parcelable