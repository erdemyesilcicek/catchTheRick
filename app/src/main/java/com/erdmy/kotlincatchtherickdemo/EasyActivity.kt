package com.erdmy.kotlincatchtherickdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_easy.*
import java.util.Random

class EasyActivity : AppCompatActivity() {

    var score = 0
    var easyImageArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable { }
    var click : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy)

        val intent = intent
        val changeMode = intent.getStringExtra("changeMode")
        val tempClick = intent.getIntExtra("click",9000)
        click = tempClick.toLong()

        textView3.text = "$changeMode"

        easyImageArray.add(imageView)
        easyImageArray.add(imageView2)
        easyImageArray.add(imageView3)
        easyImageArray.add(imageView4)
        easyImageArray.add(imageView5)
        easyImageArray.add(imageView6)
        easyImageArray.add(imageView7)
        easyImageArray.add(imageView8)
        easyImageArray.add(imageView9)

        hideImages()

        object : CountDownTimer(15500,1000)   {
            override fun onTick(p0: Long) {
                easyTimeText.text = "TIME: ${p0/1000}"
            }

            override fun onFinish() {
                easyTimeText.text = "TIME: 0"

                val alertMassage = AlertDialog.Builder(this@EasyActivity)
                alertMassage.setTitle("GAME OVER")
                alertMassage.setMessage("Restart the game?")

                alertMassage.setPositiveButton("yes") {dialog, which ->
                    val intentPositive = intent
                    finish()
                    startActivity(intentPositive)
                }

                alertMassage.setNegativeButton("no") {dialog, which ->
                    val alertMassageForNegativeButton = AlertDialog.Builder(this@EasyActivity)
                    alertMassageForNegativeButton.setTitle("Are You Sure?")
                    alertMassageForNegativeButton.setMessage("Do You Want To Go Back To The Start Menu?")

                    alertMassageForNegativeButton.setPositiveButton("yes") { dialog, which ->
                        val intentNegativePositive = Intent(this@EasyActivity, MainActivity::class.java)
                        startActivity(intentNegativePositive)
                    }

                    alertMassageForNegativeButton.setNegativeButton("no") {dialog, which ->
                        Toast.makeText(this@EasyActivity,"Game Over", Toast.LENGTH_LONG).show()
                    }
                    alertMassageForNegativeButton.show()
                }
                alertMassage.show()
            }
        }.start()
    }

    fun hideImages() {
        runnable = object : Runnable {
            override fun run() {
                for(image in easyImageArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = Random()
                val randomIndex = random.nextInt(9)

                easyImageArray[randomIndex].visibility = View.VISIBLE
                handler.postDelayed(this,click)
            }
        }
        handler.post(runnable)
    }

    fun increaseScore(view: View) {
        score++
        easyScoreText.text = "SCORE: $score"
    }
}

/*
                    //KONTROL SEBEBİ İLE BURADA

                    val alertMassageForNegativeButton = AlertDialog.Builder(this@EasyActivity)
                    alertMassageForNegativeButton.setTitle("Are You Sure?")
                    alertMassageForNegativeButton.setMessage("Do You Want To Go Back To The Start Menu?")

                    alertMassageForNegativeButton.setPositiveButton("yes") { dialog, which ->
                        val intent = Intent(this@EasyActivity, MainActivity::class.java)
                        startActivity(intent)
                    }

                    alertMassageForNegativeButton.setNegativeButton("no") {dialog, which ->
                        Toast.makeText(this@EasyActivity,"Game Over", Toast.LENGTH_LONG).show()
                    }
                    alertMassageForNegativeButton.show()
 */

