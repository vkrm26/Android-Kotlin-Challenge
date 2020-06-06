package `in`.softcrunch.flikart.data

import `in`.softcrunch.flikart.data.local.AppDatabase
import `in`.softcrunch.flikart.data.local.DBHelper
import `in`.softcrunch.flikart.data.local.entity.Product
import android.content.Context

class DataRepository(val context: Context, val dbHelper: DBHelper) : DataSourceInterface{

    companion object {

        private var INSTANCE: DataRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.
         */
        @JvmStatic
        fun getInstance(
            context: Context,
            dbHelper: DBHelper
        ): DataRepository {
            return INSTANCE ?: DataRepository(context, dbHelper)
                .apply { INSTANCE = this }
        }
    }

    override suspend fun getProducts(): List<Product> {
        return dbHelper.getProducts()
    }

}