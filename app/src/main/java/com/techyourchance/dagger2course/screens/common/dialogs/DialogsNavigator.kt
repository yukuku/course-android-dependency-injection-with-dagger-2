package com.techyourchance.dagger2course.screens.common.dialogs

import androidx.fragment.app.FragmentManager

class DialogsNavigator(
    val fragmentManager: FragmentManager,
) {
    fun showServerErrorDialog() {
        fragmentManager.beginTransaction()
            .add(ServerErrorDialogFragment.newInstance(), null)
            .commitAllowingStateLoss()
    }
}
