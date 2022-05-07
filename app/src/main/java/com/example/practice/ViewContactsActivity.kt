package com.example.practice

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.adapter.ContactAdapter
import com.example.practice.db.AppDatabase
import com.example.practice.models.Contact
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ViewContactsActivity: AppCompatActivity() {
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contacts)

        var buttonAll = findViewById<Button>(R.id.allBtn)
        buttonAll.setOnClickListener(View.OnClickListener {
            this.showContacts("All")
        })


        var buttonFamily = findViewById<Button>(R.id.familyBtn)
        buttonFamily.setOnClickListener(View.OnClickListener {
            this.showContacts("Family")
        })

        var buttonFriends = findViewById<Button>(R.id.friendsBtn)
        buttonFriends.setOnClickListener(View.OnClickListener {
            this.showContacts("Friend")
        })


        var colleagueBtn = findViewById<Button>(R.id.colleagueBtn)
        colleagueBtn.setOnClickListener(View.OnClickListener {
            this.showContacts("Colleague")
        })

        var buttonOther = findViewById<Button>(R.id.otherBtn)
        buttonOther.setOnClickListener(View.OnClickListener {
            this.showContacts("Others")
        })


        this.showContacts("All")


    }

    private fun showContacts(what:String){
        var customers = AppDatabase.getInstance(this).ContactDao().getAll()
        if(what != "All"){
            customers = AppDatabase.getInstance(this).ContactDao().searchByType(what)
        }

        val customersString = Gson().toJson(customers)
        val newCustomers: ArrayList<Contact> = Gson().fromJson(customersString,object: TypeToken<ArrayList<Contact>>(){}.type)
        val contactsAdapter = ContactAdapter(newCustomers);
        val rView = findViewById<RecyclerView>(R.id.rView)
        rView.adapter = contactsAdapter
        rView.layoutManager = LinearLayoutManager(this)
    }
}






//override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//    super.onCreate(savedInstanceState, persistentState)
//    Log.d("yes","here we are")
//    setContentView(R.layout.activity_view_contacts)
//
//    val customers = AppDatabase.getInstance(this).ContactDao().getAll()
//    val customersString = Gson().toJson(customers)
//    val newCustomers: ArrayList<Contact> = Gson().fromJson(customersString,object: TypeToken<ArrayList<Contact>>(){}.type)
//    val contactsAdapter = ContactAdapter(newCustomers);
////        val size = contactsAdapter.itemCount
////        findViewById<TextView>(R.id.totalContactTxt).text = "total Contacts: "+size.toString()
//
//    val rView = findViewById<RecyclerView>(R.id.rView)
//    rView.adapter = contactsAdapter
//    rView.layoutManager = LinearLayoutManager(this)
//
//}
