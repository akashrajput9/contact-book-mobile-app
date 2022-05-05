package com.example.practice


import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.db.AppDatabase
import com.example.practice.models.Contact

class AddContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_add_contact)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val btnAddContact = findViewById(R.id.addContactBtn) as Button
        btnAddContact.setOnClickListener(View.OnClickListener {
            val firstName = findViewById<EditText>(R.id.firstName)
            val first_name = firstName.text.toString()
            val lastName = findViewById<EditText>(R.id.lastName)
            val last_name = lastName.text.toString()
            val txtEmail = findViewById<EditText>(R.id.email)
            val email = txtEmail.text.toString()
            val txtPhone = findViewById<EditText>(R.id.phone)
            val phone = txtPhone.text.toString()
            val typeOfContact = findViewById<EditText>(R.id.typeOfContact)
            val typeContact = typeOfContact.text.toString()

            if(first_name == "" || last_name == "" || email == "" || phone == "" || typeContact == ""){
                Toast.makeText(this,Html.fromHtml("<font color='#000'>All fields are required</font>"),Toast.LENGTH_SHORT).show()
            }else{
                AppDatabase.getInstance(this).ContactDao().insert(Contact(first_name = first_name, last_name = last_name, email = email, phone = phone, type_of_contact = typeContact))
//                val sharedPref: SharedPreferences = getSharedPreferences("MY_SHARED_PREF", Context.MODE_PRIVATE)
//                val customersString = sharedPref.getString("customers","[]")
//                val customers: ArrayList<Customer> =
//                    Gson().fromJson(customersString,object: TypeToken<ArrayList<Customer>>(){}.type)
//                val newCustomer = Customer(name,email,password,phone)
//                customers.add(newCustomer)
//                with (sharedPref.edit()){
//                    putString("customers",Gson().toJson(customers))
//                    apply()
//                }
                Toast.makeText(this,Html.fromHtml("<font color='#000'>Customer Added Successfully!</font>"),Toast.LENGTH_SHORT).show()
            }

        })
    }
}