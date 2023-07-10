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
    lateinit var btnWithItem : Button
    lateinit var btnWithMItem : Button
    var items= arrayOf("dog","cat","rat")
    var booleanItems= booleanArrayOf(false,false,false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShow = findViewById(R.id.btn_alert)
        tv0 = findViewById(R.id.tv_0)
        tv0.setText(num.toString())
        btnWithItem = findViewById(R.id.btn_s_choice)
        btnWithMItem = findViewById(R.id.btn_m_choice)
        btnShow.setOnClickListener {
            AlertDialog.Builder(this,)
                .setTitle("Delete")
                .setMessage("click for show the value")
                .setCancelable(false)
                .setPositiveButton("Positive") { _, _ ->
                    num = num + 2
                    tv0.setText(num.toString())
                    Toast.makeText(this, "Positive click", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative") { _, _ ->
                    num = num - 2
                    tv0.setText(num.toString())
                    Toast.makeText(this, "Negative click", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Neutral") { _, _ ->
                    num = 0
                    tv0.setText(num.toString())
                    Toast.makeText(this, "Neutral click", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
        btnWithItem.setOnClickListener {
            AlertDialog.Builder(this,)
                .setTitle("Remove")
                .setItems(items){_,position->
                    Toast.makeText(this,"selected item ${items[position]}",Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("positive"){_,_->
                    Toast.makeText(this,"Positive click",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative"){_,_->
                    Toast.makeText(this,"Negative click",Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Neutral"){_,_->
                    Toast.makeText(this,"Neutral click",Toast.LENGTH_SHORT).show()
                }
                .show()


        }
        btnWithMItem.setOnClickListener {
            AlertDialog.Builder(this,)
                .setTitle("ITEMS")
                .setMultiChoiceItems(items, booleanItems) { _, position, isChecked ->
                    println("select position $position isChecked $isChecked")
                    for (position in 0..(booleanItems.size - 1)) {
                        if (booleanItems[position] == true) {
                            println("checked item ${items[position]}")
                        }

                    }
                    Toast.makeText(this, "selected $position $isChecked ", Toast.LENGTH_SHORT)
                        .show()
                }
                .setPositiveButton("postive") { _, _ ->
                    System.out.println("boolean array ${booleanItems} $items")
                    Toast.makeText(this, "Positive Clicked", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Negative") { _, _ ->
                    Toast.makeText(this, "Negative Clicked", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Neutral") { _, _ ->
                    Toast.makeText(this, "Neutral Clicked", Toast.LENGTH_SHORT).show()
                }

                .show()
        }
    }
    }