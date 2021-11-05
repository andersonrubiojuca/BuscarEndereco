package com.example.buscarendereo.di

import com.example.buscarendereo.cpfform.CpfFormViewModel
import com.example.buscarendereo.enderecofragment.EnderecoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory {
        EnderecoApplication()
    }

    viewModel {
        EnderecoViewModel(
            endereco = get()
        )
    }

    viewModel {
        CpfFormViewModel()
    }

}