package org.andronitysolo.task2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dasbord_admin.*

class dasbordAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dasbord_admin)
        bmi.setOnClickListener {
            val intent = Intent(this, Activity_Bmi::class.java)
            startActivity(intent)
        }

        hitung.setOnClickListener {
            val intent = Intent(this, HitungUmur::class.java)
            startActivity(intent)
        }

        Recyc.setOnClickListener {
            val mServiceIntent = Intent(this, Recycleview::class.java)
            startActivity(mServiceIntent)
        }

        List.setOnClickListener {
            val intent = Intent(this, ListView::class.java)
            startActivity(intent)
        }
    }
}