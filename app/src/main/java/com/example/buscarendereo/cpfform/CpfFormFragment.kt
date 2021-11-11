package com.example.buscarendereo.cpfform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.buscarendereo.R
import com.example.buscarendereo.databinding.FragmentCpfFormBinding
import kotlinx.android.synthetic.main.fragment_endereco.*
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
        binding.viewModel = viewModel
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        with(binding){
            pesquisarbutton.setOnClickListener {
                this@CpfFormFragment.viewModel.pesquisar(cpfCampo.text.toString())
            }
        }
    }

    private fun setObservers() {

        viewModel.estado.observe(viewLifecycleOwner, { estado ->
            if(estado == CpfStatus.DONE){
                viewModel.endereco.value?.let {

                    if (this.findNavController().currentDestination?.id == R.id.cpfFormFragment){
                        this.findNavController().navigate(
                            CpfFormFragmentDirections.actionCpfFormFragmentToEnderecoFragment(it)
                        )
                    }
                }
            }

            if(estado == CpfStatus.ERROR){
                binding.erroLabel.visibility = View.VISIBLE
                binding.cpfCampo.setText("")
            }
        })
    }

}