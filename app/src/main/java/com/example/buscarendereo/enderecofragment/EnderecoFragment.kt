package com.example.buscarendereo.enderecofragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.buscarendereo.databinding.FragmentEnderecoBinding
import com.example.buscarendereo.network.Endereco
import org.koin.androidx.viewmodel.ext.android.viewModel


class EnderecoFragment : Fragment() {

    private lateinit var binding: FragmentEnderecoBinding
    private val viewModel: EnderecoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentEnderecoBinding.inflate(inflater, container, false).apply {
        binding = this
        init()
    }.root

    private fun init(){
        val endereco = EnderecoFragmentArgs.fromBundle(requireArguments()).selectedProperty
        viewModel.setEndereco(endereco)
        binding.viewModel = viewModel

        setListeners(endereco)
        setObservers()
    }


    private fun setListeners(endereco: Endereco){
        // sinto que estou fazendo errado
        binding.cepResultado.setText(endereco.cep)
        binding.logradouroCampo.setText(endereco.logradouro)
        binding.complementoCampo.setText(endereco.complemento)
        binding.bairroCampo.setText(endereco.bairro)
        binding.cidadeCampo.setText(endereco.localidade)
        binding.ufCampo.setText(endereco.uf)
        binding.ibgeCampo.setText(endereco.ibge)
        binding.giaCampo.setText(endereco.gia)
        binding.dddCampo.setText(endereco.ddd)
        binding.siafiCampo.setText(endereco.siafi)

        binding.voltarButton.setOnClickListener {
            voltar()
        }

        /**
         * por algum motivo só com esse comando para o back funcionar...
         */
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    voltar()
                }
            })
    }

    private fun setObservers(){}

    private fun voltar() {
        this.findNavController().navigate(
            EnderecoFragmentDirections.actionEnderecoFragmentToCpfFormFragment()
        )
    }

}

