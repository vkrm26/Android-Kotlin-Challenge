package `in`.softcrunch.flikart.data.local

import `in`.softcrunch.flikart.data.local.entity.Product

class AppDBHelper(private val appDatabase: AppDatabase) : DBHelper {
    override suspend fun getProducts(): List<Product> = appDatabase.productDao().getAllProducts()
}