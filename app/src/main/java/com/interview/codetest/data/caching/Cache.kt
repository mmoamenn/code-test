package com.interview.codetest.data.caching

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.interview.codetest.data.response.PageResponse
import org.koin.core.KoinComponent
import org.koin.core.inject

class Cache : KoinComponent {

    private val context: Context by inject()

    private val pref: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(
            context
        )
    }

    fun saveItem(key: String, page: PageResponse) {
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putString(key, Gson().toJson(page))
        editor.apply()
    }

    fun loadItem(key: String): PageResponse? {
        val item = pref.getString(key, null)
        return if (item != null)
            Gson().fromJson(item, PageResponse::class.java)
        else
            null
    }

}