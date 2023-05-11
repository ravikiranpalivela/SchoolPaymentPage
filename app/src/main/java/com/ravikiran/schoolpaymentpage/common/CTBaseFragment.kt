package com.ravikiran.schoolpaymentpage.common


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment


abstract class CTBaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBindingRelations()
        setupObservers()
    }

    open fun setupBindingRelations() {}
    open fun setupObservers() {}

    abstract fun getViewModel(): CTBaseViewModel?

    open fun shouldBackPress() = true

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        getViewModel()?.onCleared()
    }
}

