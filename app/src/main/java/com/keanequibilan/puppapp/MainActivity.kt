package com.keanequibilan.puppapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewController
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewController
import com.keanequibilan.puppapp.ui.theme.PuppAppTheme
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val puppyListController: PuppyListViewController by inject()
    private val animeListViewController: AnimeListViewController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppAppTheme {
                animeListViewController.Compose()
            }
        }
    }
}
