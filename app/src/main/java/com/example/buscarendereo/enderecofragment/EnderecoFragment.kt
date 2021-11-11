package com.example.buscarendereo.enderecofragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.buscarendereo.databinding.FragmentEnderecoBinding
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
        viewModel.setEndereco(EnderecoFragmentArgs.fromBundle(requireArguments()).selectedProperty)
        binding.viewModel = viewModel

        setListeners()
        setObservers()
    }

    private fun setListeners(){
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

