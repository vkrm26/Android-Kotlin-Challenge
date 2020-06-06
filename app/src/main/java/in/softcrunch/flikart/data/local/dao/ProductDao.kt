package `in`.softcrunch.flikart.data.local.dao

import `in`.softcrunch.flikart.data.local.entity.Product
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(productList: List<Product>)

    @Query("SELECT * FROM product")
    suspend fun getAllProducts() : List<Product>

}