package com.example.buscarendereo.di

import com.example.buscarendereo.core.enderecoServiceCore
import com.example.buscarendereo.cpfform.CpfFormViewModel
import com.example.buscarendereo.enderecofragment.EnderecoViewModel
import com.example.buscarendereo.domain.network.EnderecoService
import com.example.buscarendereo.domain.network.GetCepInformationDataSource
import com.example.buscarendereo.domain.repository.GetCepInformationRepository
import com.example.buscarendereo.domain.repository.GetCepInformationRepositoryImpl
import com.example.buscarendereo.domain.userCases.GetCepInformationUserCase
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

private const val BASE_URL = "https://viacep.com.br/"

val apiModules = module {

    single { enderecoServiceCore(BASE_URL, EnderecoService::class.java) }
    single { GetCepInformationDataSource(service = get()) }
    single<GetCepInformationRepository> { GetCepInformationRepositoryImpl(dataSource = get()) }

}

val domainModule = module {
    factory { GetCepInformationUserCase(repository = get()) }
}

val viewModelModules = module {
    viewModel {
        CpfFormViewModel(getCepInformation = get())
    }

    viewModel {
        EnderecoViewModel()
    }

}