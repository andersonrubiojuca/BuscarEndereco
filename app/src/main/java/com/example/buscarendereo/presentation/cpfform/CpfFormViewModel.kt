package com.example.buscarendereo.presentation.cpfform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscarendereo.domain.network.Endereco
import com.example.buscarendereo.domain.userCases.GetCepInformationUserCase
import kotlinx.coroutines.launch

class CpfFormViewModel(
    private val getCepInformation: GetCepInformationUserCase
): ViewModel(){

    sealed class Action{
        data class ChangeEndereco(val endereco: Endereco): Action()
    }

    internal val action = MutableLiveData<Action>()

    fun find(cep: String){
        val rawCep = toJson(cep)
        viewModelScope.launch {
            runCatching { getCepInformation(rawCep) }
                .onSuccess {
                    action.postValue(Action.ChangeEndereco(it))
                }
                .onFailure {
                    action.postValue(Action.ChangeEndereco(
                        Endereco("", "", "", "", "", "", "", "", "", ""))
                    )
                }
        }
    }

    private fun toJson(valor: String?): String{
        if (valor != null)
            return valor.substring(0,5) + valor.substring(6,9)

        return ""
    }

}