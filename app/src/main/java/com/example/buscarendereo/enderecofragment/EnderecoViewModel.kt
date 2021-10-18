package com.example.buscarendereo.enderecofragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.buscarendereo.network.Endereco

class EnderecoViewModel(endereco: Endereco, app: Application): AndroidViewModel(app) {

    private val _endereco = MutableLiveData<Endereco>()
            val endereco: LiveData<Endereco>
                get() = _endereco

    private val _voltar = MutableLiveData<Boolean>()
            val voltar: LiveData<Boolean>
                get() = _voltar

    init {
        _endereco.value = endereco
        _voltar.value = false
    }

    fun retornar(){
        _voltar.value = true
    }

}