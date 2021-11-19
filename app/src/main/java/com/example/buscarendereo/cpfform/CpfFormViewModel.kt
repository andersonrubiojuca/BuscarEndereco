package com.example.buscarendereo.cpfform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buscarendereo.network.Endereco
import com.example.buscarendereo.network.EnderecoApi

enum class CpfStatus {LOADING, ERROR, DONE }

class CpfFormViewModel: ViewModel(){

    internal sealed class Action{
        data class ChangeEndereco(val cpfStatus: CpfStatus): Action()
    }

    internal val action = MutableLiveData<Action>()

    suspend fun pesquisar(cep: String): Endereco?{
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

    private fun toJson(valor: String?): String{
        if (valor != null)
            return valor.substring(0,5) + valor.substring(6,9)

        return ""
    }

}