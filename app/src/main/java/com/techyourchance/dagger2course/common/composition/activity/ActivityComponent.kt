package com.techyourchance.dagger2course.common.composition.activity

import com.techyourchance.dagger2course.common.composition.presentation.PresentationComponent
import dagger.Subcomponent

@Subcomponent(
    modules = [ActivityModule::class],
)
@ActivityScope
interface ActivityComponent {

    // Convention: to create a subcomponent.
    // The parameter must be a module, but can be omitted if the module class has a default ctor.
    fun createPresentationComponent(): PresentationComponent
}
