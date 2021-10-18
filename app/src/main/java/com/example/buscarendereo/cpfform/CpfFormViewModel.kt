package com.example.buscarendereo.cpfform

import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buscarendereo.network.Endereco
import com.example.buscarendereo.network.EnderecoApi
import kotlinx.coroutines.launch

enum class CpfStatus { LOADING, ERROR, DONE }

class CpfFormViewModel() : ViewModel(){

    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    private val _estado = MutableLiveData<CpfStatus>()
            val estado: LiveData<CpfStatus>
                get() = _estado

    var cep = MutableLiveData<String>()

    init {
        cep.value = ""
    }


    private val _endereco = MutableLiveData<Endereco>()
            val endereco: LiveData<Endereco>
                get() = _endereco


    fun pesquisar(){
        viewModelScope.launch {
            _estado.value = CpfStatus.LOADING
            try {
                val cepjson = toJson(cep.value)
                cep.value = ""

                _endereco.value = EnderecoApi.retrofitService.getJson(cepjson)
                _estado.value = CpfStatus.DONE
            } catch (e: Exception){
                _estado.value = CpfStatus.ERROR
                cep.value = ""
                e.message
            }
        }
        cep.value = _endereco.value.toString()
    }

    fun apagarCpf(){
        cep.value = ""
    }

    private fun toJson(valor: String?): String{
        if (valor != null)
            return valor.substring(0,5) + valor.substring(6,9)

        return ""
    }

}