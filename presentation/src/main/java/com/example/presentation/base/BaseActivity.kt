package com.example.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var loading: View

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(getLayoutID())
        bindView()

    }
    protected abstract fun getLayoutID():Int

    protected fun bindView() {}

    //TODO: IMPLEMENT LOADERS FUN

    public fun showLoading(){

    }

    public fun hideLoading(){

    }
}