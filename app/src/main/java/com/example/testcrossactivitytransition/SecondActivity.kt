package com.example.testcrossactivitytransition

import android.app.Activity
import android.os.Build
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.testcrossactivitytransition.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            overrideActivityTransition(
                /* overrideType = */ OVERRIDE_TRANSITION_OPEN,
                /* enterAnim = */ R.anim.slide_in_right,
                /* exitAnim = */ R.anim.slide_out_left
            )
            overrideActivityTransition(
                /* overrideType = */ OVERRIDE_TRANSITION_CLOSE,
                /* enterAnim = */ R.anim.slie_in_left,
                /* exitAnim = */ R.anim.slide_out_right
            )
        }
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
    }
}