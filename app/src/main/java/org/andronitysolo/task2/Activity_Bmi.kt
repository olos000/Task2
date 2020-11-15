package org.andronitysolo.task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity__bmi.*
import java.text.DecimalFormat

class Activity_Bmi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__bmi)
        jumlah.setOnClickListener {
            var berat = berat.text.toString().trim()
            var tinggi = tinggi.text.toString().trim()
            when {
                tinggi.isEmpty() -> {
                    tinggi = "Tinggi Wajib diisi"
                }
                berat.isEmpty() -> {
                    berat = "Berat Wajib diisi"
                }
                else -> {
                    val tinggiMeter = tinggi.toInt() * 0.01
                    val bmi = berat.toInt() / (tinggiMeter * tinggiMeter)
                    val df = DecimalFormat("#.##")
                    val bmiResult = df.format(bmi)
                    if (jekel.checkedRadioButtonId == R.id.p) {
                        when {
                            bmi < 18 -> {
                                hasil.text = "Kurus"
                            }
                            bmi in 18.0..25.0 -> {
                                hasil.text = "Normal"
                            }
                            bmi in 25.0..27.0 -> {
                                hasil.text = "Kegemukan"
                            }
                            bmi > 27 -> {
                                hasil.text = "Obesitas"
                            }

                        }
                    } else if (jekel.checkedRadioButtonId == R.id.w) {
                        when {
                            bmi < 17 -> {
                                hasil.text = "Kurus"
                            }
                            bmi in 17.0..23.0 -> {
                                hasil.text = "Normal"
                            }
                            bmi in 23.0..27.0 -> {
                                hasil.text = "Kegemukan"
                            }
                            bmi > 27 -> {
                                hasil.text = "Obesitas"
                            }

                        }

                    }
                    jumlH.text = bmiResult.toString()

                }
            }

        }


    }
}