package `in`.softcrunch.flikart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var productListFragment: ProductListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productListFragment = supportFragmentManager.findFragmentById(R.id.content_frame)
                as ProductListFragment? ?: ProductListFragment.newInstance().also {
            replaceFragmentInActivity(it, R.id.content_frame)
        }
    }
}
