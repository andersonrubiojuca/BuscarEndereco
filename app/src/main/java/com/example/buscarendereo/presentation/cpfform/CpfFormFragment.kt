package com.example.buscarendereo.presentation.cpfform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.buscarendereo.databinding.FragmentCpfFormBinding
import com.example.buscarendereo.domain.network.Endereco
import kotlinx.android.synthetic.main.fragment_endereco.*
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CpfFormFragment : Fragment() {

    private val viewModel by viewModel<CpfFormViewModel>()
    private lateinit var binding: FragmentCpfFormBinding

    override fun onCreateView(
        inflater: LayoutInflater
        , container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCpfFormBinding.inflate(inflater, container, false).apply{
        binding = this
        init()
    }.root

    private fun init(){
        //binding.viewModel = viewModel
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        with(binding){
            pesquisarbutton.setOnClickListener {
                lifecycleScope.launch {
                    this@CpfFormFragment.viewModel.find(cpfCampo.text.toString())
                }
            }
        }
    }

    private fun setObservers() {

        viewModel.action.observe(viewLifecycleOwner, { action ->
            when(action){
                is CpfFormViewModel.Action.ChangeEndereco -> enter(action.endereco)
            }
        })
    }

    private fun enter(endereco: Endereco){

        // pode ser qualquer atributo (menos os ocultos)
        if (endereco.bairro != "") {
            findNavController().navigate(
                    CpfFormFragmentDirections.actionCpfFormFragmentToEnderecoFragment(endereco)
                )
        } else {
            returnError()
        }
    }

    private fun returnError(){
        binding.erroLabel.visibility = View.VISIBLE
        binding.cpfCampo.setText("")
    }

}