package com.coby.kanji.di

import android.content.Context
import com.coby.kanji.mapper.toCharacter
import com.coby.kanji.model.CharacterDTO
import com.coby.kanji.entity.Character
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModules {
    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideMyJsonData(@ApplicationContext context: Context, gson: Gson): List<Character> {
        val jsonString = context.assets.open("characters.json").bufferedReader().use { it.readText() }
        val characterDTOs: List<CharacterDTO> = gson.fromJson(jsonString, object : TypeToken<List<CharacterDTO>>() {}.type)
        val characters: List<Character> = characterDTOs.map { it.toCharacter() }
        return characters
    }
}