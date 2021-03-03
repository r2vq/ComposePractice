package com.keanequibilan.puppapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.keanequibilan.puppapp.ui.puppylist.PuppyListView
import com.keanequibilan.puppapp.ui.puppylist.PuppyListViewModel
import com.keanequibilan.puppapp.ui.theme.PuppAppTheme

class MainActivity : AppCompatActivity() {

    private val puppyListViewModel by viewModels<PuppyListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PuppyListView(puppyListViewModel)
                }
            }
        }
    }
}
