package com.example.vizualis.shopping

import android.content.Context
import androidx.room.*
import androidx.room.Database

@Database(version = 1, entities = [ShoppingItemForDb::class])
abstract class ShoppingDatabase: RoomDatabase(){
   abstract fun shoppingItemForDbDao(): ShoppingItemForDbDao
}

object Database {
   private var instance: ShoppingDatabase? = null
   fun getInstance(context: Context) = instance
      ?: Room.databaseBuilder(
      context.applicationContext, ShoppingDatabase::class.java, "shopping-db"
   ).allowMainThreadQueries()
      .build()
      .also { instance = it }
}

@Entity(tableName = "shopping_item")
data class ShoppingItemForDb(
   val title: String,
   val text: String,
   @PrimaryKey(autoGenerate = true) var uid: Long = 0
)

@Dao
interface ShoppingItemForDbDao {
   @Insert
   fun insertAll(vararg items: ShoppingItemForDb): List<Long>

   @Query("SELECT * FROM shopping_item")
   fun getAll(): List<ShoppingItemForDb>

   @Query("SELECT * FROM shopping_item WHERE uid == :itemId")
   fun getItemById(itemId: Long): ShoppingItemForDb

   @Update
   fun update(item: ShoppingItemForDb)

   @Delete
   fun delete(item: ShoppingItemForDb)
}

