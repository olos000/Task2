package org.andronitysolo.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_hitung_umur.*
import java.util.*

class HitungUmur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_umur)
        tvUmurmu.visibility = View.INVISIBLE

        btnHitungUmurmu.setOnClickListener {
            //mendapatkan tahun saat ini
            val currYear = Calendar.getInstance().get(Calendar.YEAR)
            val tahunlahir = etTahunLahir.text.toString().toInt()
            //Hitung (tahun ini - tahun lahir)
            val userAge = currYear - tahunlahir
            //Set hasil ke text view
            tvUmurmu.text = "Umur mu adalah : $userAge Tahun"
            //tampilkan text hasil
            tvUmurmu.visibility = View.VISIBLE
        }
    }
}