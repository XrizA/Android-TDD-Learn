package io.github.xriza

import io.github.xriza.api.IProductAPI
import io.github.xriza.api.ProductResponse

interface IProductRepository {

    fun getProduct(productId: String, loadProductCallback: LoadProductCallback)

    fun buy(id: String, items: Int, callback: BuyProductCallback)

    interface LoadProductCallback {
        fun onProductResult(productResponse: ProductResponse)
    }

    interface BuyProductCallback {
        fun onBuyResult(isSuccess: Boolean)
    }
}

class ProductRepository(private val productAPI: IProductAPI) : IProductRepository {

    override fun getProduct(
        productId: String,
        loadProductCallback: IProductRepository.LoadProductCallback) {
        productAPI.getProduct(productId, object : IProductAPI.ProductDataCallback {
            override fun onGetResult(productResponse: ProductResponse) {
                loadProductCallback.onProductResult(productResponse)
            }
        })
    }

    override fun buy(id: String, items: Int, callback: IProductRepository.BuyProductCallback) {
        if (items <= 10)
            callback.onBuyResult(true)
        else
            callback.onBuyResult(false)
    }

}