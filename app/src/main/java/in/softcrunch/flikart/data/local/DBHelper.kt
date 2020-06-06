package `in`.softcrunch.flikart.data.local

import `in`.softcrunch.flikart.data.local.entity.Product

interface DBHelper {

    suspend fun getProducts(): List<Product>

}