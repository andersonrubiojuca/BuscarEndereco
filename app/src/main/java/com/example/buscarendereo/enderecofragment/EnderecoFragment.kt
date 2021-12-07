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
        //binding.viewModel = viewModel

        setListeners(endereco)
        setObservers()
    }


    private fun setListeners(endereco: Endereco){
        with(binding){
            cepResultado.setText(endereco.cep)
            logradouroCampo.setText(endereco.logradouro)
            complementoCampo.setText(endereco.complemento)
            bairroCampo.setText(endereco.bairro)
            cidadeCampo.setText(endereco.localidade)
            ufCampo.setText(endereco.uf)
            ibgeCampo.setText(endereco.ibge)
            giaCampo.setText(endereco.gia)
            dddCampo.setText(endereco.ddd)
            siafiCampo.setText(endereco.siafi)

            voltarButton.setOnClickListener {
                back()
            }
        }


        /**
         * por algum motivo só com esse comando para o back funcionar...
         */
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    back()
                }
            })
    }

    private fun setObservers(){}

    private fun back() {
        this.findNavController().navigate(
            EnderecoFragmentDirections.actionEnderecoFragmentToCpfFormFragment()
        )
    }

}

