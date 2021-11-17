package com.example.buscarendereo.enderecofragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buscarendereo.network.Endereco

class EnderecoViewModel: ViewModel() {

    internal sealed class Action(var endereco: Endereco){
    }

    private val action = MutableLiveData<Action>()

    fun setEndereco(endereco: Endereco){
        action.value?.endereco = endereco
    }
}