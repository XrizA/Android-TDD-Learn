package io.github.xriza

import io.github.xriza.api.ProductResponse

class ProductPresenter(
    private val view: ProductContract.IProductView,
    private val productRepository: IProductRepository
) : ProductContract.IProductPresenter {

    override fun getProduct(productId: String) {
        productRepository.getProduct(productId, object : IProductRepository.LoadProductCallback {

            override fun onProductResult(productResponse: ProductResponse) {
                view.onGetResult(productResponse)
            }
        })
    }

}