package com.example.apirequestssession.features.todo.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.apirequestssession.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class SecondActivity: AppCompatActivity() {

    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btn = findViewById(R.id.btn_get_todos)
        btn.setOnClickListener {
//            val jsonBody = "{ username: 'sample', token: 'token'}"
//            lifecycleScope.launch(Dispatchers.IO) {  makeLoginRequest(jsonBody) }

            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private val loginUrl = "https://example.com/login"

    sealed class Result<out R> {
        data class Success<out T>(val data: T) : Result<T>()
        data class Error(val exception: Exception) : Result<Nothing>()
    }

    suspend fun makeLoginRequest(
        jsonBody: String
    ) {
        val url = URL(loginUrl)
        (withContext(Dispatchers.IO) {
            url.openConnection()
        } as? HttpURLConnection)?.run {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json; utf-8")
            setRequestProperty("Accept", "application/json")
            doOutput = true
            outputStream.write(jsonBody.toByteArray())
//            Result.Success(responseParser.parse(inputStream))
        }
//        return Result.Error(Exception("Cannot open HttpURLConnection"))
    }
}