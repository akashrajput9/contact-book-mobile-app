package com.example.practice


import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.db.AppDatabase
import com.example.practice.models.Contact

class AddContactActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var contactTypes = arrayOf("Family", "Friend", "Colleague", "Others")

    var spinner:Spinner? = null
//    var textView_msg = findViewById<TextView>(R.id.selectedItem)
var selectedSpinner: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_add_contact)

        spinner = this.findViewById<Spinner>(R.id.typeOfContact)
        spinner!!.setOnItemSelectedListener(this)

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, contactTypes)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(aa)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val btnAddContact = findViewById<Button>(R.id.insertContact)
        btnAddContact.setOnClickListener(View.OnClickListener {

            var first_name = findViewById<EditText>(R.id.firstName)
            var last_name = findViewById<EditText>(R.id.lastName)
            var txt_email = findViewById<EditText>(R.id.email)
            var txt_phone = findViewById<EditText>(R.id.phone)


            val firstName = first_name.text.toString()
            val lastName = last_name.text.toString()
            val txtEmail = txt_email.text.toString()
            val txtPhone = txt_phone.text.toString()
            val typeOfContact = selectedSpinner
            if(firstName == "" || lastName == "" || txtEmail == "" || txtPhone == "" ){
                Toast.makeText(this,"All fields are required",Toast.LENGTH_SHORT).show()
            }else{
                AppDatabase.getInstance(this).ContactDao().insert(Contact(first_name = firstName, last_name = lastName, email = txtEmail, phone = txtPhone, type_of_contact = typeOfContact))
                Toast.makeText(this,"Contact Added Successfully!",Toast.LENGTH_SHORT).show()
                first_name.setText("")
                last_name.setText("")
                txt_email.setText("")
                txt_phone.setText("")
            }

        })



    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//        findViewById<TextView>(R.id.selectedItem).text = "Selected : "+languages[p2]
//        Log.d("langual",languages[p2]);
        this.selectedSpinner= contactTypes[p2];
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}

private fun EditText.setText(c: Char) {

}
