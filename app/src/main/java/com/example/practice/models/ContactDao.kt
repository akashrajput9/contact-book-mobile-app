package com.example.practice.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(customer: Contact)

    @Query("SELECT * FROM contacts ORDER BY id DESC")
    fun getAll(): List<Contact>


    @Query("SELECT * FROM contacts WHERE type_of_contact LIKE :searchQuery")
    // and then search query will be passed through
    // the perimeter of this function
    // and then function will return the flow of list of person
    fun searchByType(searchQuery: String): List<Contact>
}