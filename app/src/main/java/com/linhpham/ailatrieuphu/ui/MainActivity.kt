package com.linhpham.ailatrieuphu.ui

import androidx.activity.viewModels
import com.linhpham.ailatrieuphu.base.BaseActivity
import com.linhpham.ailatrieuphu.databinding.ActivityMainBinding
import com.linhpham.ailatrieuphu.utils.ext.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val viewModel by viewModels<MainActivityViewModel>()
    override fun initView() {

    }

    override fun observer() {
        viewModel.apply {
            currentUserId.observe(this@MainActivity) {
                showToast(it)
            }
        }
    }

    override fun initEvent() {
        binding.btnOk.setOnClickListener {
            viewModel.setCurrentUser(binding.edt.text.toString())
        }
    }

}