package com.ewenlucas.mad_rentable.helpers

import android.content.Context
import androidx.room.Room
import com.ewenlucas.mad_rentable.db.AppDatabase

class AppDatabaseHelper(context: Context)
{
    // Bloc de code "static" :
    companion object
    {
        // Helper :
        private lateinit var databaseHelper: AppDatabaseHelper

        // Getter instance :
        fun getDatabase(context: Context): AppDatabase
        {
            if (!Companion::databaseHelper.isInitialized)
            {
                databaseHelper = AppDatabaseHelper(context)
            }
            return databaseHelper.database
        }
    }

    // Base de données :
    val database: AppDatabase = Room
        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "cars.db")
        .allowMainThreadQueries()
        .build()
}