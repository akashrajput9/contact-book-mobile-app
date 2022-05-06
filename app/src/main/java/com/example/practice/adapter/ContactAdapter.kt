package com.example.practice.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.MainActivity
import com.example.practice.R
import com.example.practice.db.AppDatabase
import com.example.practice.models.Contact


class ContactAdapter(val contacts: ArrayList<Contact>): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    class ContactViewHolder(viewHolder: View): RecyclerView.ViewHolder(viewHolder)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.list_contacts,p0,false)
        )
    }

    override fun onBindViewHolder(p0: ContactViewHolder, p1: Int) {
        val currentCustomer = contacts[p1];
        p0.itemView.apply {
            p0.itemView.findViewById<TextView>(R.id.lFisrtName).setText(currentCustomer.first_name)
            p0.itemView.findViewById<TextView>(R.id.lLastName).setText(currentCustomer.last_name)
            p0.itemView.findViewById<TextView>(R.id.lPhone).setText(currentCustomer.phone)
            p0.itemView.findViewById<TextView>(R.id.lEmail).setText(currentCustomer.email)
            p0.itemView.findViewById<TextView>(R.id.lType).setText(currentCustomer.type_of_contact)

            p0.itemView.findViewById<Button>(R.id.deleteBtn).setOnClickListener(View.OnClickListener {
//                Toast.makeText(this, "Clearing the data...",
//                    Toast.LENGTH_SHORT).show();

                removeItem(p1)
            })
        }
    }

    fun addItem(customer: Contact){
        contacts.add(customer)
        this.notifyItemInserted(contacts.size-1);
    }
    private fun removeItem(index:Int){
//        AppDatabase.ContactDao().deleteById(index)
        AppDatabase.getInstance(MainActivity()).ContactDao().delete(contacts[index])
        contacts.removeAt(index)
        notifyItemRemoved(index)
        notifyItemRangeChanged(index, itemCount)
    }



    override fun getItemCount(): Int {
        return contacts.size;
    };


}