package `in`.softcrunch.flikart.data

import `in`.softcrunch.flikart.data.local.entity.Product

interface DataSourceInterface {
    suspend fun getProducts(): List<Product>
}