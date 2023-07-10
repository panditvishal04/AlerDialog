package com.vishal.alerdialog

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btnShow:Button
    lateinit var tv0: TextView
    var num=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShow=findViewById(R.id.btn_alert)
        tv0=findViewById(R.id.tv_0)
        tv0.setText(num.toString())
        btnShow.setOnClickListener {
            AlertDialog.Builder(this,)
                .setTitle("Delete")
                .setMessage("click for show the value")
                .setCancelable(false)
                .setPositiveButton("Positive"){_,_->
                    num=num+2
                    tv0.setText(num.toString())
                    Toast.makeText(this,"Positive click",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative"){_,_->
                    num=num-2
                    tv0.setText(num.toString())
                    Toast.makeText(this,"Negative click",Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Neutral"){_,_->
                    num=0
                    tv0.setText(num.toString())
                    Toast.makeText(this,"Neutral click",Toast.LENGTH_SHORT).show()
                }
                .show()
        }

    }
}