package com.example.buscarendereo.enderecofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.buscarendereo.R
import com.example.buscarendereo.databinding.FragmentEnderecoBinding


class EnderecoFragment : Fragment() {

    private lateinit var binding: FragmentEnderecoBinding
    private lateinit var viewModel: EnderecoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentEnderecoBinding.inflate(inflater, container, false).apply {
        binding = this
        init()
    }.root

    private fun init(){
        //val application = requireNotNull(activity).application
        val endereco = EnderecoFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = EnderecoViewModelFactory(endereco)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(EnderecoViewModel::class.java)
        binding.viewModel = viewModel

        setListeners()
        setObservers()

        //binding.endereco.text = endereco.toString()
    }

    private fun setListeners(){
        binding.voltarButton.setOnClickListener {
            this.findNavController().navigate(
                EnderecoFragmentDirections.actionEnderecoFragmentToCpfFormFragment()
            )
        }
    }

    private fun setObservers(){}

}

