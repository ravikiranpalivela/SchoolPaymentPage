package com.ravikiran.schoolpaymentpage.common

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class CTViewModelFactory<VM : CTBaseViewModel>(val creator: () -> VM) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return creator() as T
    }
}

open class CTBaseViewModel(app: Application) : AndroidViewModel(app) {


    public override fun onCleared() {
        super.onCleared()
    }

    companion object {
        private val TAG = CTBaseViewModel::class.java.simpleName
    }
}
