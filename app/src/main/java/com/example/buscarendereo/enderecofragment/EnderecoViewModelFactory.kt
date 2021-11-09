package com.example.buscarendereo.enderecofragment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.buscarendereo.network.Endereco

//class EnderecoViewModelFactory(
//    private val endereco: Endereco): ViewModelProvider.Factory {
//
//    @Suppress("unchecked_cast")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(EnderecoViewModel::class.java)){
//            return EnderecoViewModel(endereco) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//
//}