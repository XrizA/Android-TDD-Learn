package io.github.xriza

import io.github.xriza.api.ProductResponse

class ProductContract {

    interface IProductView {
        fun onGetResult(productResponse: ProductResponse)
    }

    interface IProductPresenter {
        fun getProduct(productId: String)
    }

}