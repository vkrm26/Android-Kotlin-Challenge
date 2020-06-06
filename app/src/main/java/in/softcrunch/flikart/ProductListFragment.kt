package `in`.softcrunch.flikart

import `in`.softcrunch.flikart.data.local.entity.Product
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.product_list_fragment.rv_products

class ProductListFragment : Fragment() {

    companion object {
        fun newInstance() = ProductListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel : ProductListViewModel by viewModels()

        rv_products.layoutManager = GridLayoutManager(context, 2)
        val productAdapter = ProductAdapter(requireContext(), ArrayList())
        rv_products.adapter = productAdapter

        viewModel.getProducts().observe(viewLifecycleOwner, Observer { productList ->

            if (productList != null && productList.isNotEmpty()) {
                productAdapter.setProductList(productList)
            }

        })
    }
}