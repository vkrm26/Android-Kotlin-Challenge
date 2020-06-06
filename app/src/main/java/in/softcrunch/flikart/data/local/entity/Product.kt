package `in`.softcrunch.flikart.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
class Product {

    @PrimaryKey
    var id : Long = 0

    @ColumnInfo
    var title : String = ""

    @ColumnInfo
    var productImage : String = ""

    @ColumnInfo
    var price : Double = 0.0
}