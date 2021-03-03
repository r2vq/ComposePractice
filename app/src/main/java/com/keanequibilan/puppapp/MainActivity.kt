package com.keanequibilan.puppapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.keanequibilan.puppapp.ui.page.MainScreenViewController
import com.keanequibilan.puppapp.ui.theme.PuppAppTheme
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val mainScreenViewController: MainScreenViewController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppAppTheme {
                mainScreenViewController.Compose()
            }
        }
    }
}
