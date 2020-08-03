package com.anledev.project_sample.data.ui.shoppinglist

import com.anledev.project_sample.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}