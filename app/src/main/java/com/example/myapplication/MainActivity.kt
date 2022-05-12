package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


private lateinit var text: TextView
private lateinit var edit: EditText
private lateinit var check: CheckBox
private lateinit var button: Button
private lateinit var progress: ProgressBar
private var inProgerss = false


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.textView2)
        edit = findViewById(R.id.editText)
        check = findViewById(R.id.checkBox)
        button = findViewById(R.id.button)
        progress = findViewById(R.id.progressBar)

        button.setOnClickListener {
            Change()
        }
    }

    /*var SomeTask: Thread = object : Thread() {
        override fun run() {
            var i = 0
            while (i <=100){
                progress.setProgress(i)
                i++
                Thread.sleep(20)
            }
            this@MainActivity.runOnUiThread(java.lang.Runnable {

                val str = edit.text
                if (str.isEmpty())
                    text.text = "Text is empty"
                else{
                    text.text = edit.text
                }
            })
            progress.setProgress(0)
        }
    }*/

    private fun Change(){

        if(!inProgerss) {
            inProgerss = true
            if (check.isChecked)
                Toast.makeText(applicationContext, "Hello toast!", Toast.LENGTH_SHORT).show()

            Thread(Runnable {
                var i = 0
                while (i <= 100) {
                    progress.setProgress(i)
                    i++
                    Thread.sleep(20)
                    progress.setProgress(0)
                }
                this@MainActivity.runOnUiThread(java.lang.Runnable {

                    val str = edit.text
                    if (str.isEmpty())
                        text.text = "Text is empty"
                    else {
                        text.text = edit.text
                    }
                })
                inProgerss = false
            }).start()
        }

        /*if (!SomeTask.isAlive) {
            if(SomeTask.state == Thread.State.TERMINATED){
                Log.e("as", "is terminated")
                SomeTask.run()
            }
            else
                SomeTask.start();
        }*/
    }
}





