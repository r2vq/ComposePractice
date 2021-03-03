package com.keanequibilan.puppapp.ui.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

@Composable
fun loadPicture(
    url: String
): MutableState<Bitmap?> = mutableStateOf<Bitmap?>(null)
    .also {
        Glide.with(LocalContext.current)
            .asBitmap()
            .load(url)
            .into<CustomTarget<Bitmap>>(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap>?
                ) {
                    it.value = resource
                }

                override fun onLoadCleared(placeholder: Drawable?) {}
            })
    }
