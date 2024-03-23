package com.coby.kanji.util

import android.content.Context
import android.content.SharedPreferences
import android.speech.tts.TextToSpeech
import java.util.Locale

object TTSManager : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private lateinit var preferences: SharedPreferences

    private const val PREFS_NAME = "tts_preferences"
    private const val IS_ON_KEY = "isOn"

    fun init(context: Context) {
        if (tts == null) {
            tts = TextToSpeech(context, this)
            preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts?.language = Locale.JAPAN
        }
    }

    fun speak(text: String) {
        if (isOn) {
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    val isOn: Boolean
        get() = preferences.getBoolean(IS_ON_KEY, true)

    fun setOn(isOn: Boolean) {
        preferences.edit().putBoolean(IS_ON_KEY, isOn).apply()
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
    }
}