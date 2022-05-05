package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.adapter.ContactAdapter
import com.example.practice.db.AppDatabase
import com.example.practice.models.Contact
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customers = AppDatabase.getInstance(this).ContactDao().getAll()
        val customersString = Gson().toJson(customers)
        val newCustomers: ArrayList<Contact> = Gson().fromJson(customersString,object: TypeToken<ArrayList<Contact>>(){}.type)
        val customersAdapter = ContactAdapter(newCustomers);

        val rView = findViewById<RecyclerView>(R.id.rView)
        rView.adapter = customersAdapter
        rView.layoutManager = LinearLayoutManager(this)

        val addCustomerBtn = findViewById<Button>(R.id.addContactBtn)
        addCustomerBtn.setOnClickListener(View.OnClickListener {
            val addCustomerIntent = Intent(this,AddContactActivity::class.java);
            startActivity(addCustomerIntent)
        })
    }
}