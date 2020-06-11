package io.github.xriza.api

import android.os.Handler

interface IProductAPI {
    interface ProductDataCallback {
        fun onGetResult(productResponse: ProductResponse)
    }

    fun getProduct(productId: String, ProductDataCallback: ProductDataCallback)
}

class ProductAPI : IProductAPI {
    override fun getProduct(
        productId: String,
        ProductDataCallback: IProductAPI.ProductDataCallback) {
        val handler = Handler()
        handler.postDelayed(Runnable {
            val productResponse = ProductResponse()
            productResponse.id = "pixel3"
            productResponse.name = "Google Pixel 3"
            productResponse.desc = "5.5吋螢幕"
            productResponse.price = 27000
            ProductDataCallback.onGetResult(productResponse)
        }, 1000)
    }
}