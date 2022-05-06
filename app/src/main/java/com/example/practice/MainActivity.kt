package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
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



//        val customers = AppDatabase.getInstance(this).ContactDao().getAll()
//        val customersString = Gson().toJson(customers)
//        val newCustomers: ArrayList<Contact> = Gson().fromJson(customersString,object: TypeToken<ArrayList<Contact>>(){}.type)
//        val contactsAdapter = ContactAdapter(newCustomers);
//        val size = contactsAdapter.itemCount
//        findViewById<TextView>(R.id.totalContactTxt).text = "total Contacts: "+size.toString()
//
//        val rView = findViewById<RecyclerView>(R.id.rView)
//        rView.adapter = contactsAdapter
//        rView.layoutManager = LinearLayoutManager(this)

        val addContactBtn = findViewById<Button>(R.id.addContactBtn)
        addContactBtn.setOnClickListener(View.OnClickListener {
            val customerIntent = Intent(this,AddContactActivity::class.java);
            startActivity(customerIntent)
        })

        val ViewContactBtn = findViewById<Button>(R.id.viewContactsBtn)
        ViewContactBtn.setOnClickListener(View.OnClickListener {
            val viewContactIntent = Intent(this,ActivityViewContacts::class.java);
            startActivity(viewContactIntent)
        })
    }
}