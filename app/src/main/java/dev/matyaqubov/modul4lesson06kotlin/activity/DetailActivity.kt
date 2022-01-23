package dev.matyaqubov.modul4lesson06kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.matyaqubov.modul4lesson06kotlin.R
import android.widget.TextView
import dev.matyaqubov.modul4lesson06kotlin.model.Member

class DetailActivity : AppCompatActivity() {

    private lateinit var textViewName: TextView
    private  lateinit var textViewPhone:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
    }
    private fun initViews() {
        textViewName = findViewById(R.id.tv_name)
        textViewPhone = findViewById(R.id.tv_phone)
        val member: Member? = intent.getParcelableExtra("member")
        textViewName.setText(member!!.name)
        textViewPhone.setText(member.phoneNumber)
    }
}