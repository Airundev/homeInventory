package com.inventory.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import androidx.core.content.res.getResourceIdOrThrow
import com.inventory.R
import kotlinx.android.synthetic.main.inventory_list_cell.view.*

class InventoryListCell @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.inventory_list_cell, this)
        setupAttributes(attrs)
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.InventoryListCell, 0, 0)

        // Icon
        setImage(typedArray.getResourceIdOrThrow(R.styleable.InventoryListCell_inventoryListCellImage))

        // Title
        setTitle(typedArray.getText(R.styleable.InventoryListCell_inventoryListCellTitle)?.toString())

        //Subtitle
        setSubTitle(typedArray.getText(R.styleable.InventoryListCell_inventoryListCellSubtitle)?.toString())

        //ActionImage
        setActionImage(typedArray.getResourceIdOrThrow(R.styleable.InventoryListCell_inventoryListCellActionImage))
    }

    fun setImage(@DrawableRes icon: Int?) {
        if (icon == null) {
            inventoryListCellImage.visibility = View.GONE
        } else {
            inventoryListCellImage.visibility = View.VISIBLE
            inventoryListCellImage.setImageResource(icon)
        }
    }

    fun setTitle(text: String?) {
        inventoryListCellTitle.text = text
    }

    fun setSubTitle(text: String?) {
        inventoryListCellSubTitle.text = text
    }

    fun setActionImage(@DrawableRes icon: Int?) {
        if (icon == null) {
            inventoryListCellActionImage.visibility = View.GONE
        } else {
            inventoryListCellActionImage.visibility = View.VISIBLE
            inventoryListCellActionImage.setImageResource(icon)
        }
    }
}