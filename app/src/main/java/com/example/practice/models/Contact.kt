package com.example.practice.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val first_name: String,
    val last_name: String,
    val phone:String,
    val email: String ,
    val type_of_contact: String,

):Serializable;
