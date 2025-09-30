package com.example.latihan_fragment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val angka1 = findViewById<EditText>(R.id.angka1)
        val angka2 = findViewById<EditText>(R.id.angka2)
        val btnAdd = findViewById<Button>(R.id.btnAdd)


        if (savedInstanceState==null){
            replaceFragment(Fragment1())
        }

        btnAdd.setOnClickListener {

            val fragmenthasil = hasil()
            val num1 = angka1.text.toString().toInt()
            val num2 = angka2.text.toString().toInt()
            var calculate =num1 +num2

            val datakirim = Bundle().apply {
                putString("HasilTambah",calculate.toString())
            }
            fragmenthasil.arguments = datakirim

           replaceFragment2(fragmenthasil)
        }



    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentmanaget = supportFragmentManager
        val fragmenttransaction = fragmentmanaget.beginTransaction()

        fragmenttransaction.replace(R.id.fragment_container, fragment)
        fragmenttransaction.addToBackStack(null)
        fragmenttransaction.commit()

    }
    private fun replaceFragment2(fragment : Fragment) {
        val fragmentmanaget = supportFragmentManager
        val fragmenttransaction = fragmentmanaget.beginTransaction()

        fragmenttransaction.replace(R.id.fragment_container2, fragment)
        fragmenttransaction.addToBackStack(null)
        fragmenttransaction.commit()

    }
}