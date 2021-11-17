package com.example.buscarendereo.cpfform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscarendereo.enderecofragment.EnderecoViewModel
import com.example.buscarendereo.network.Endereco
import com.example.buscarendereo.network.EnderecoApi
import kotlinx.coroutines.launch

enum class CpfStatus {LOADING, ERROR, DONE }

class CpfFormViewModel: ViewModel(){

    internal sealed class Action{
        data class ChangeEndereco(val cpfStatus: CpfStatus): Action()
    }

    internal val action = MutableLiveData<Action>()


//    private var _estado = MutableLiveData<CpfStatus>()
//            val estado: LiveData<CpfStatus>
//                get() = _estado

//    private var _endereco = MutableLiveData<Endereco>()
//            val endereco: LiveData<Endereco>
//                get() = _endereco

    fun pesquisar(cepp: String): Endereco?{
        var endereco: Endereco? = null
        viewModelScope.launch {
            action.postValue(Action.ChangeEndereco(CpfStatus.LOADING))
            try {
                endereco = EnderecoApi.retrofitService.getJson(toJson(cepp))
                action.postValue(Action.ChangeEndereco(CpfStatus.DONE))
            } catch (e: Exception){
                action.postValue(Action.ChangeEndereco(CpfStatus.ERROR))
                e.message
            }
        }

        return endereco
    }

    private fun toJson(valor: String?): String{
        if (valor != null)
            return valor.substring(0,5) + valor.substring(6,9)

        return ""
    }

}