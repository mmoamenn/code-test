package com.interview.codetest.presenter.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.interview.codetest.presenter.sections.SectionActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finishActivity()
    }

    private fun finishActivity() {
        lifecycleScope.launch(Dispatchers.IO) {
            delay(2000)
            startActivity(Intent(this@SplashActivity, SectionActivity::class.java))
            finish()
        }
    }
}
