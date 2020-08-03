package com.anledev.project_sample.data.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.anledev.project_sample.R
import com.anledev.project_sample.data.db.entities.ShoppingItem

import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

//class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :
class AddShoppingItemDialog(context: Context, val func: ((ShoppingItem) -> Unit)) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString().toInt()
            if (name.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount)
//            addDialogListener.onAddButtonClicked(item)
            func.invoke(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}