package com.ravikiran.schoolpaymentpage

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ravikiran.schoolpaymentpage.common.CTBaseActivity
import com.ravikiran.schoolpaymentpage.common.CTBaseFragment
import com.ravikiran.schoolpaymentpage.common.CTBaseViewModel
import com.ravikiran.schoolpaymentpage.common.CTViewModelFactory
import com.ravikiran.schoolpaymentpage.databinding.ActivityMainBinding
import com.ravikiran.schoolpaymentpage.features.ui.cart.CartAdapter
import com.ravikiran.schoolpaymentpage.features.ui.cart.CartViewModel

class MainActivity : CTBaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel: CartViewModel by viewModels {
        CTViewModelFactory {
            CartViewModel(application)
        }
    }

    private var adapter = CartAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        setTitle("iGuru Portal Service Pvt.Ltd")
        homeViewModel.getCartItems()

        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter


    }

    override fun setupObservers() {
        homeViewModel.cartItems?.observe(this, Observer {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        })

        homeViewModel.studentDetails?.observe(this, Observer {
            binding.tvStName.text = it?.name
            binding.tvStId.text = it?.studentID
        })

//        homeViewModel.totalPrice?.observe(this, Observer {
////            binding.tvTotalPrice.text = it.toString()
//        })
    }




    override fun getViewModel() = homeViewModel

    override fun getCurrentFragment(): CTBaseFragment? {
        return null
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}