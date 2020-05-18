package com.interview.codetest.core.di

import com.interview.codetest.CodeTestApplication
import com.interview.codetest.data.caching.Cache
import com.interview.codetest.data.api.NetworkAPI
import com.interview.codetest.data.repository.SectionRepository
import com.interview.codetest.presenter.sections.SectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    single { CodeTestApplication.appContext }

    single { NetworkAPI() }

    viewModel { SectionViewModel(get()) }

    single { SectionRepository() }

    single { Cache() }

}