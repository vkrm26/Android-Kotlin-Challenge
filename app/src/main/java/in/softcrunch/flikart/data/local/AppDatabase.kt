package `in`.softcrunch.flikart.data.local

import `in`.softcrunch.flikart.Const.DATABASE_VERSION
import `in`.softcrunch.flikart.Const.DB_NAME
import `in`.softcrunch.flikart.data.local.dao.ProductDao
import `in`.softcrunch.flikart.data.local.entity.Product
import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = DATABASE_VERSION, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao() : ProductDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                        .createFromAsset("database/flikart.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}