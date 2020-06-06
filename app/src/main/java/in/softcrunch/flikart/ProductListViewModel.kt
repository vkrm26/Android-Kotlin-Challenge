package `in`.softcrunch.flikart

import `in`.softcrunch.flikart.data.DataSourceInterface
import `in`.softcrunch.flikart.data.local.entity.Product
import `in`.zapr.onemedia.data.Injection
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductListViewModel(application: Application): AndroidViewModel(application) {

    private var dataSourceInterface: DataSourceInterface = Injection.provideDataRepository(application.applicationContext)

    private val products: MutableLiveData<List<Product>> by lazy {
        MutableLiveData<List<Product>>().also {
            loadProducts()
        }
    }

    fun getProducts(): LiveData<List<Product>> {
        return products
    }

    private fun loadProducts() {
        viewModelScope.launch {
            val list = dataSourceInterface.getProducts()
            products.value = list
            Log.d("size", "" + list.size)
        }
    }
}

