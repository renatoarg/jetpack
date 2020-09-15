package br.com.renatoarg.commons

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import javax.inject.Inject

class PreferencesHelper @Inject constructor(
    context: Context
) {

    private val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)

    private fun edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = sharedPrefs.edit()
        operation(editor)
        editor.apply()
    }

    private inline operator fun <reified T : Any> SharedPreferences.get(
        key: String,
        defaultValue: T? = null
    ): T = when (T::class) {
        String::class -> getString(key, defaultValue as? String ?: "") as T
        Int::class -> getInt(key, defaultValue as? Int ?: -1) as T
        Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T
        Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T
        Long::class -> getLong(key, defaultValue as? Long ?: -1) as T
        else -> throw UnsupportedOperationException("Not yet implemented")
    }

    fun set(key: String, value: Any?) {
        when (value) {
            is String? -> edit { it.putString(key, value) }
            is Int -> edit { it.putInt(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            is Float -> edit { it.putFloat(key, value) }
            is Long -> edit { it.putLong(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    fun getString(key: String): String? {
        return sharedPrefs.getString(key, null)
    }

    fun getInt(key: String, default: Int): Int {
        return sharedPrefs.getInt(key, default)
    }

    fun getBoolean(key: String, default: Boolean): Boolean {
        return sharedPrefs.getBoolean(key, default)
    }

    fun getFloat(key: String, default: Float): Float {
        return sharedPrefs.getFloat(key, default)
    }

    fun getLong(key: String, default: Long): Long {
        return sharedPrefs.getLong(key, default)
    }

}