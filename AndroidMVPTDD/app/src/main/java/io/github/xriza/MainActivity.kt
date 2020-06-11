package io.github.xriza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.xriza.api.ProductAPI
import io.github.xriza.api.ProductResponse
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), ProductContract.IProductView {
    private val productId = "pixel3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productRepository = ProductRepository(ProductAPI())

        val productPresenter = ProductPresenter(this, productRepository)

        productPresenter.getProduct(productId)
    }

    override fun onGetResult(productResponse: ProductResponse) {
        productName.text = productResponse.name
        productDesc.text = productResponse.desc

        val currencyFormat = NumberFormat.getCurrencyInstance()
        currencyFormat.maximumFractionDigits = 0
        val price = currencyFormat.format(productResponse.price)
        productPrice.text = price
    }
}