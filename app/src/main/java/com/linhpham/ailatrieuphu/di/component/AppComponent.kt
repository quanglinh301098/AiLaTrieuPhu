package com.linhpham.ailatrieuphu.di.component

import com.linhpham.ailatrieuphu.di.module.app.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface AppComponent {

}