package br.com.unitysystem.safebox

import android.app.Application
import android.content.Context
import br.com.unitysystem.safebox.network.services

private const val KEY_PREFERENCES =  "key_preferences"
private const val KEY_TOKEN =  "key_token"

class App: Application() {

    companion object {
        private lateinit var instance: App

        private val preferences by lazy {
            instance.getSharedPreferences(KEY_PREFERENCES, Context.MODE_PRIVATE)
        }

        fun saveToken (token: String) {
            preferences.edit()
                .putString(KEY_TOKEN, token)
                .apply()
        }

        fun getToken() = preferences.getString(KEY_TOKEN, null)

        val apiService by lazy { services() }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}