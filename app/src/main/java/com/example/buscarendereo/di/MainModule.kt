package com.example.buscarendereo.di

import com.example.buscarendereo.cpfform.CpfFormViewModel
import com.example.buscarendereo.enderecofragment.EnderecoViewModel
import com.example.buscarendereo.enderecofragment.EnderecoViewModelFactory
import com.example.buscarendereo.network.Endereco
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
//    factory<Endereco> {
//        EnderecoApplication()
//    }
    single {
        Endereco(get(), get(), get(), get(), get(), get(), get(), get(), get(), get())
    }

    single {
        EnderecoServiceImpl(get()) as EnderecoServiceInt
    }

    viewModel {
        CpfFormViewModel()
    }

    viewModel {
        EnderecoViewModel(get())
    }

}