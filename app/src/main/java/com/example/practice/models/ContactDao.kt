package com.example.practice.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(customer: Contact)

    @Query("SELECT * FROM contacts ORDER BY id ASC")
    fun getAll(): List<Contact>
}