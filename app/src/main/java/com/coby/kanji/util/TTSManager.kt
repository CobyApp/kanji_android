package com.coby.kanji.util

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

object TTSManager : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null

    fun init(context: Context) {
        if (tts == null) {
            tts = TextToSpeech(context, this)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts?.language = Locale.JAPAN
        }
    }

    fun speak(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
    }
}