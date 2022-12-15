package com.erdmy.kotlincatchtherickdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun easy(view: View) {
        val intent = Intent(this@MainActivity, EasyActivity::class.java)
        intent.putExtra("click", 1000)
        intent.putExtra("changeMode","!EASY MODE!")
        startActivity(intent)
    }

    fun medium(view: View) {
        val intent = Intent(this@MainActivity, EasyActivity::class.java)
        intent.putExtra("click", 450)
        intent.putExtra("changeMode","!MEDIUM MODE!")
        startActivity(intent)
    }

    fun hard(view: View) {
        val intent = Intent(this@MainActivity, EasyActivity::class.java)
        intent.putExtra("click", 200)
        intent.putExtra("changeMode","!HARD MODE!")
        startActivity(intent)
    }

    fun insane(view: View) {
        val intent = Intent(this@MainActivity, EasyActivity::class.java)
        intent.putExtra("click", 100)
        intent.putExtra("changeMode","!INSANE MODE!")
        startActivity(intent)
    }
}