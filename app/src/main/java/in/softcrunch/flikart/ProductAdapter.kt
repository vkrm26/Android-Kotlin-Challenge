package `in`.softcrunch.flikart

import `in`.softcrunch.flikart.data.local.entity.Product
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(val context: Context, var products: List<Product>) : RecyclerView.Adapter<ProductVH>() {

    private var productList : List<Product>

    init {
        this.productList = products
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductVH(context, itemView)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        holder.bindData(productList[position])
    }

    fun setProductList(productList : List<Product>) {
        this.productList = productList
        notifyDataSetChanged()
    }
}