package org.andronitysolo.task2

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var btn: Button
    private lateinit var edtus: EditText
    private lateinit var edtpass: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn)
        btn.setOnClickListener(this)

        edtus = findViewById(R.id.edt_user)
        edtpass = findViewById(R.id.edt_pass)


    }

    override fun onClick(v: View?) {
        btn.setOnClickListener {
            val username = edtus.text.toString()
            val password = edtpass.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please Insert Email and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (username == "admin" || password == "admin") {
                val progressDialog = ProgressDialog(
                    this,
                    R.style.Theme_MaterialComponents_Light_Dialog
                )
                progressDialog.isIndeterminate = true
                progressDialog.setMessage("Loading...")
                progressDialog.show()
                val intent = Intent(this, dasbordAdmin::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}