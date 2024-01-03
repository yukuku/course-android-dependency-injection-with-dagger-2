package com.techyourchance.dagger2course.common.composition.app

import com.techyourchance.dagger2course.common.composition.activity.ActivityComponent
import com.techyourchance.dagger2course.common.composition.activity.ActivityModule
import dagger.Component

@Component(
    modules = [AppModule::class],
)
@AppScope
interface AppComponent {

    fun createActivityComponent(activityModule: ActivityModule): ActivityComponent
}
