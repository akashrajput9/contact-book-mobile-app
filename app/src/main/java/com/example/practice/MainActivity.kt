package com.example.practice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        val contactsAdapter = ContactAdapter(newCustomers);
        val size = contactsAdapter.itemCount
        findViewById<TextView>(R.id.totalContactTxt).text = "total Contacts: "+size.toString()
//
//        val rView = findViewById<RecyclerView>(R.id.rView)
//        rView.adapter = contactsAdapter
//        rView.layoutManager = LinearLayoutManager(this)

        val addContactBtn = findViewById<Button>(R.id.addContactBtn)
        addContactBtn.setOnClickListener(View.OnClickListener {
            val customerIntent = Intent(this,AddContactActivity::class.java);
            startActivity(customerIntent)
        })

        val viewContactsBtn = findViewById<Button>(R.id.viewContactsBtn)
        viewContactsBtn.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
//            val viewContactIntent = Intent(this,ActivityViewContacts::class.java);
//            startActivity(viewContactIntent)
            val viewContactIntent: Intent = Intent(this,ViewContactsActivity::class.java)
            startActivity(viewContactIntent)
        })
    }


}