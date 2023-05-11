package com.ravikiran.schoolpaymentpage.common

import android.os.Bundle
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity

//TODO - Add common logic here
abstract class CTBaseActivity : AppCompatActivity() {

    private var layoutListener: ViewTreeObserver.OnGlobalLayoutListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initiating Binding logic only after view is laid out
        // Normally this is not needed. But on screen rotation,
        // it seems to be taking some time to lay out the views.
        layoutListener = ViewTreeObserver.OnGlobalLayoutListener {
            setupBindingRelations()
            setupObservers()
            // Not sure how many times layoutListener is triggered. Just to be on the safer side.
            // Removing the listener once the view is laid out
            window.decorView.rootView.viewTreeObserver.removeOnGlobalLayoutListener(layoutListener)
        }
        window.decorView.rootView.viewTreeObserver.addOnGlobalLayoutListener(layoutListener)
    }

    open fun setupBindingRelations() {}

    open fun setupObservers() {}

    abstract fun getCurrentFragment(): CTBaseFragment?

    abstract fun getViewModel(): CTBaseViewModel?

    /*override fun onBackPressed() {
        if (getCurrentFragment()?.shouldBackPress() == true)
            super.onBackPressed()
    }*/
}