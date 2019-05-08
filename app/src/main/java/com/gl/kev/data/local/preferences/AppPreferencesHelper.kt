package com.gl.kev.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import com.gl.kev.di.qualifier.ApplicationContext
import com.gl.kev.di.qualifier.PreferenceInfo
import javax.inject.Inject

class AppPreferencesHelper @Inject constructor(
    @ApplicationContext context: Context,
    @PreferenceInfo prefFileName: String
) : PreferencesHelper {

    companion object {
        const val PREF_KEY_SOME = "PREF_KEY_SOME"
    }

    private var mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getSomeKey(): String? {
        return getStringKey(PREF_KEY_SOME, null)
    }

    override fun setSomeKey(value: String) {
        setStringKey(PREF_KEY_SOME, value)
    }

    private fun getStringKey(key: String, defValue: String?): String? {
        return mPrefs.getString(key, defValue)
    }

    private fun setStringKey(key: String, value: String) {
        mPrefs.edit().putString(key, value).apply()
    }

}