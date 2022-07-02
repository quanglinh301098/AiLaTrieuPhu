package com.linhpham.ailatrieuphu.ui

import android.content.Intent
import android.os.Handler
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.ktx.Firebase
import com.linhpham.ailatrieuphu.R
import com.linhpham.ailatrieuphu.base.BaseActivity
import com.linhpham.ailatrieuphu.databinding.ActivityMainBinding
import com.linhpham.ailatrieuphu.utils.ext.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val viewModel by viewModels<MainActivityViewModel>()
    private lateinit var navController: NavController
    override fun initView() {
        navController =
            NavHostFragment.findNavController(supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment)

    }

    override fun observer() {
        viewModel.apply {
            currentUserId.observe(this@MainActivity) {
                showToast(it)
            }
        }
    }

    override fun initEvent() {
        Handler().postDelayed({
            navController.navigate(R.id.actionMainToFragmentLogin)
        }, 3000)

    }


}