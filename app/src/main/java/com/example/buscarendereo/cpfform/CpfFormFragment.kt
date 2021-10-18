package com.example.buscarendereo.cpfform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.transition.Visibility
import com.example.buscarendereo.R
import com.example.buscarendereo.databinding.FragmentCpfFormBinding
import kotlinx.android.synthetic.main.fragment_endereco.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 * Use the [CpfFormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CpfFormFragment : Fragment() {

    private val viewModel: CpfFormViewModel by lazy {
        ViewModelProvider(this).get(CpfFormViewModel::class.java)
    }

    private lateinit var binding: FragmentCpfFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cpf_form, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.endereco.observe(viewLifecycleOwner, Observer {
            if (it != null){
                if (this.findNavController().currentDestination?.id == R.id.cpfFormFragment) {
                    this.findNavController().navigate(
                        CpfFormFragmentDirections.actionCpfFormFragmentToEnderecoFragment(it)
                    )
                }
                viewModel.apagarCpf()
            }
        })

        viewModel.estado.observe(viewLifecycleOwner, Observer {
            if(it == CpfStatus.ERROR){
                binding.erroLabel.visibility = View.VISIBLE
            }
        })

        return binding.root
    }

}