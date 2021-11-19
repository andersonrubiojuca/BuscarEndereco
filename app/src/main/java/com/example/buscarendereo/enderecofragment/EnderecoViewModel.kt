package com.example.buscarendereo.enderecofragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buscarendereo.cpfform.CpfFormViewModel
import com.example.buscarendereo.cpfform.CpfStatus
import com.example.buscarendereo.network.Endereco

class EnderecoViewModel: ViewModel() {

    internal sealed class Action(){
        data class ChangeEndereco(val boolean: Boolean): Action()
    }

    private val action = MutableLiveData<Action>()

}