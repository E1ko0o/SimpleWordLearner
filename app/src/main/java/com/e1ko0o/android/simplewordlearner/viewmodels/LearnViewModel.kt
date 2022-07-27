package com.e1ko0o.android.simplewordlearner.viewmodels

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder

class LearnViewModel(application: Application) : AndroidViewModel(application) {
    val ldWord = MutableLiveData<String>()
    val ldTranslatedWord = MutableLiveData<String>()
    private var srcOfImage: String =
        "https://wordinfo.info/words/images/querulous-1.jpg" //@todo leave empty brackets
    private val BASE: String by lazy {"https://www.google.com/search?q=$srcOfImage&hl=EN&tbm=isch&sclient=img"}

    private fun getSrcOfImage() {
        Log.d("MY_TAG", BASE)
    }

    fun getImage(): RequestBuilder<Drawable> {
        ldWord.value = "apple fruit"
        val context = getApplication<Application>().applicationContext
        prepareQueryString()
        getSrcOfImage()
        return Glide.with(context).load(srcOfImage).skipMemoryCache(true)
    }

    private fun prepareQueryString() {
        srcOfImage = ldWord.value.toString().replace(" ", "+")
    }

    fun copyText(text: String): Boolean {
        val context = getApplication<Application>().applicationContext
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText(text, text)
        clipboard?.setPrimaryClip(clip) ?: return false
        return true
    }
}