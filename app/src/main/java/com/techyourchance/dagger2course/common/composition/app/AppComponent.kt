package com.techyourchance.dagger2course.common.composition.app

import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Component
import retrofit2.Retrofit

@Component(
    modules = [AppModule::class],
)
@AppScope
interface AppComponent {

    fun retrofit(): Retrofit

    fun stackoverflowApi(): StackoverflowApi
}
