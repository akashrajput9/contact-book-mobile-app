package com.example.practice.models

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(customer: Contact)

    @Query("SELECT * FROM contacts ORDER BY id DESC")
    fun getAll(): List<Contact>


    @Query("SELECT * FROM contacts WHERE type_of_contact LIKE :searchQuery")
    fun searchByType(searchQuery: String): List<Contact>


    @Delete
    fun delete(contact:Contact)
}