package com.example.buscarendereo.cpfform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscarendereo.domain.network.Endereco
import com.example.buscarendereo.domain.network.EnderecoApi
import com.example.buscarendereo.domain.userCases.GetCepInformationUserCase
import kotlinx.coroutines.launch

enum class CpfStatus {LOADING, ERROR, DONE }

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

    /*
    suspend fun find(cep: String): Endereco?{
        val endereco: Endereco?

        action.postValue(Action.ChangeEndereco(CpfStatus.LOADING))
        return try {
            endereco = EnderecoApi.retrofitService.getJson(toJson(cep))
            action.postValue(Action.ChangeEndereco(CpfStatus.DONE))

            endereco
        } catch (e: Exception){
            action.postValue(Action.ChangeEndereco(CpfStatus.ERROR))
            e.message

            null
        }
    }

     */

    private fun toJson(valor: String?): String{
        if (valor != null)
            return valor.substring(0,5) + valor.substring(6,9)

        return ""
    }

}