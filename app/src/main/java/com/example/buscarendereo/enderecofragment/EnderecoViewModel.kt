package com.example.buscarendereo.enderecofragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EnderecoViewModel: ViewModel() {

    internal sealed class Action{
        data class ChangeEndereco(val boolean: Boolean): Action()
    }

    private val action = MutableLiveData<Action>()

}