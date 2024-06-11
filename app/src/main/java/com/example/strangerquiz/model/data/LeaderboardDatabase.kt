package com.example.strangerquiz.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LeaderboardEntity::class], version = 1)
abstract class LeaderboardDatabase: RoomDatabase() {
    abstract fun leaderboardDao(): LeaderboardDao
    companion object{
        private var instance: LeaderboardDatabase? = null
        fun getInstance(context: Context): LeaderboardDatabase?{
            if (instance == null){
                synchronized(LeaderboardDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LeaderboardDatabase::class.java,
                        "leaderboard.sqlite"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance
        }
    }
}