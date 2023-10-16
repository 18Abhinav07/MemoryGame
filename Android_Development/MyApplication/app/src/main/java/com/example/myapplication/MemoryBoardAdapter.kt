package com.example.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.BoardSize
import java.lang.Integer.min

// viewHolder is an object that provides the view to all the elements of a particular recycler view.
class MemoryBoardAdapter(private val context: Context, private val boardSize: BoardSize) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {
    // companion objects are like static in java , you can create values which might be needed in
    // the flow of the program.
    companion object {
        private const val MARGIN_SIZE = 30
        private const val TAG = "MemoryBoardAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardWidth = parent.width / boardSize.getWidth() - (2 * MARGIN_SIZE)
        val cardHeight = parent.height / boardSize.getHeight() - (2 * MARGIN_SIZE)
        val cardSideLength = min(cardWidth, cardHeight)

        val view = LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)
        // to dynamically set the width and height of tne card layout.
        // you can find the element by its id and then apply the details.
        val layoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardSideLength
        layoutParams.height = cardSideLength
        layoutParams.setMargins(MARGIN_SIZE)


        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = boardSize.numCards


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)


        fun bind(position: Int) {

            // to add the on click functionality to the card view.
            imageButton.setOnClickListener {
                Log.i(TAG, "Clicked on position $position.")
            }

        }
    }

}
