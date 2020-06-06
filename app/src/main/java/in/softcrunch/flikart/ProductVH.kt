package `in`.softcrunch.flikart

import `in`.softcrunch.flikart.data.local.entity.Product
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class ProductVH(val context: Context, rootView: View) : ViewHolder(rootView) {

    private var img_product : ImageView = rootView.findViewById<ImageView>(R.id.img_product)
    private var title : TextView = rootView.findViewById(R.id.txt_title)
    private var price : TextView = rootView.findViewById(R.id.txt_price)

    fun bindData(product : Product) {

        Glide.with(img_product.context)
            .load(product.productImage)
            .into(img_product)

        title.text = product.title
        price.text = product.price.toString()
    }

}