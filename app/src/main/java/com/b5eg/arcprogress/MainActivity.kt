package com.b5eg.arcprogress

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cv_arc_progress.apply {
            strokeWidth = 35F

            setData(922F, 1000F)
        }
    }

}
