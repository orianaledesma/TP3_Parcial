package com.ort.edu.parcial_tp3.listener

import com.ort.edu.parcial_tp3.model.Product

/**
 * Esta interfaz sera utilizada para ser implementada cuando se quiera manejar la seleccion de un producto en una clase
 */
interface OnProductClickedListener {

    /**
     * Se invoca cuando se selecciona un producto de la lista
     */
    fun onProductSelected(product: Product)
}