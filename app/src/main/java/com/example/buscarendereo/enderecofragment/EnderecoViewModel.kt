package com.example.buscarendereo.enderecofragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buscarendereo.network.Endereco

class EnderecoViewModel(): ViewModel() {

    private val _endereco = MutableLiveData<Endereco>()
            val endereco: LiveData<Endereco>
                get() = _endereco

    fun setEndereco(endereco: Endereco){
        _endereco.value = endereco
    }
}