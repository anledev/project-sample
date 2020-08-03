package com.anledev.project_sample.data.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.anledev.project_sample.data.db.entities.ShoppingItem
import com.anledev.project_sample.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun upsert(item: ShoppingItem) = GlobalScope.launch { repository.upsert(item) }
    fun upsert2(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch { repository.upsert(item) }

    fun delete(item: ShoppingItem) = GlobalScope.launch { repository.delete(item) }
    fun delete2(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch { repository.delete(item) }

    fun getAllShoppingItems() = repository.getAllShoppingItems()

}