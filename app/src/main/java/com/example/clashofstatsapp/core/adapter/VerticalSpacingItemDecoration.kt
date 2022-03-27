package com.example.clashofstatsapp.core.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalSpacingItemDecoration constructor(
    private val firstItemTopSpacing: Int = 0,
    private val betweenItemsSpacing: Int,
    private val lastItemBottomSpacing: Int = 0,
    private val edgeSpacing: Int = 0
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildViewHolder(view).adapterPosition
        val itemCount = state.itemCount
        setSpacing(outRect = outRect, isFirstItem = position == 0, isLastItem = position == itemCount - 1)
    }

    private fun setSpacing(outRect: Rect, isFirstItem: Boolean, isLastItem: Boolean) {
        outRect.left = edgeSpacing
        outRect.right = edgeSpacing
        outRect.top = if (isFirstItem) firstItemTopSpacing else betweenItemsSpacing / 2
        outRect.bottom = if (isLastItem) lastItemBottomSpacing else betweenItemsSpacing / 2
    }
}