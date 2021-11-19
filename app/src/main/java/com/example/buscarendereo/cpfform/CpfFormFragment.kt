package com.example.buscarendereo.cpfform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.buscarendereo.R
import com.example.buscarendereo.databinding.FragmentCpfFormBinding
import com.example.buscarendereo.network.Endereco
import kotlinx.android.synthetic.main.fragment_endereco.*
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CpfFormFragment : Fragment() {

    private val viewModel by viewModel<CpfFormViewModel>()
    private var endereco: Endereco? = null
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
        binding.viewModel = viewModel
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        with(binding){
            pesquisarbutton.setOnClickListener {
                lifecycleScope.launch {
                    this@CpfFormFragment.endereco =
                        this@CpfFormFragment.viewModel.pesquisar(cpfCampo.text.toString())
                }
            }
        }
    }

    private fun setObservers() {

        viewModel.action.observe(viewLifecycleOwner, { action ->
            when(action){
                CpfFormViewModel.Action.ChangeEndereco(CpfStatus.DONE) -> entrar()
                CpfFormViewModel.Action.ChangeEndereco(CpfStatus.ERROR) -> retornarErro()
            }
        })
    }

    private fun entrar(){
        val enderecoNav = endereco
        enderecoNav?.let {
            //esse if evita um bug que evita de ir na segunda tela
            if (this.findNavController().currentDestination?.id == R.id.cpfFormFragment) {
                this.findNavController().navigate(
                    CpfFormFragmentDirections.actionCpfFormFragmentToEnderecoFragment(enderecoNav)
                )
            }
        } ?: run {
            retornarErro()
        }
    }

    private fun retornarErro(){
        binding.erroLabel.visibility = View.VISIBLE
        binding.cpfCampo.setText("")
    }

}