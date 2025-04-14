package com.example.practicalista.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicalista.R
import com.example.practicalista.databinding.ActivityPersonDetailBinding
import com.example.practicalista.models.Person
import com.example.practicalista.repositories.PersonRepository

class PersonDetailActivity : AppCompatActivity() {
    //aqui va la logica del proyecto
    private var person: Person? = null
    private lateinit var binding: ActivityPersonDetailBinding
    private var selectColorBtn = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPersonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainAPD)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        person = intent.getSerializableExtra(PARAM_PERSON) as Person?
        loadPersonDetails(person)
        setupEventListeners()
        selectColor()
    }

    private fun setupEventListeners() {
        binding.btnCancel.setOnClickListener { finish() }
        binding.btnSavePerson.setOnClickListener { savePerson() }
        binding.btnDelete.setOnClickListener { deletePerson() }
    }

    private fun deletePerson() {
        PersonRepository.deletePerson(person!!)
        finish()
    }

    private fun savePerson() {
        PersonRepository.savePerson(
            Person(
                person?.id ?: 0,
                binding.txtName.editText?.text.toString(),
                // binding.txtLastName.editText?.text.toString()
               // binding.txtPhone.editText?.text.toString(),
                // binding.txtEmail.editText?.text.toString(),
                binding.txtAddress.editText?.text.toString()
               // false,
                //selectColor,
            )
        )
        finish()
    }

    private fun loadPersonDetails(person: Person?) {
        if (person == null) {
            return
        }
        binding.txtName.editText?.setText(person.name)
        //binding.txtLastName.editText?.setText(person.lastName)
        //binding.txtPhone.editText?.setText(person.phone)
        //binding.txtEmail.editText?.setText(person.email)
        binding.txtAddress.editText?.setText(person.address)
    }

    private fun selectColor() {
        /*val listColorBtn = listOf(
            R.id.btnC1,R.id.btnC2,R.id.btnC3,R.id.btnC04,R.id.btnC5,
            R.id.btnC6,R.id.btnC7,R.id.btnC8,R.id.btnC9,R.id.btnC10
        )

        listColorBtn.forEachIndexed{
                index, buttonId ->
            findViewById<Button>(buttonId).setOnClickListener {
                selectColorBtn = colorBtnId[index]
        }*/
    }

    companion object {
        const val PARAM_PERSON = "person"

        fun detailIntent(context: Context, person: Person): Intent? {
            val intent = Intent(context, PersonDetailActivity::class.java)
            intent.putExtra(PARAM_PERSON, person)
            return intent
        }
    }
}