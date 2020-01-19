package com.example.presentation

import android.os.Bundle
import android.os.PersistableBundle
import com.example.presentation.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun getLayoutID(): Int {
        return R.layout.main_activity
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        finish()
    }
}