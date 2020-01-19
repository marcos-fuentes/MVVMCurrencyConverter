package com.example.presentation.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    protected abstract fun observeViewModel()

    protected abstract fun getLayout()

    protected abstract fun bindViews()

    override fun onStart() {
        super.onStart()
        observeViewModel()
    }

}