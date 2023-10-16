package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.BoardSize

class MainActivity : AppCompatActivity() {

    // creates a late initialised variable for all the item in xml so that they are made when onCreate
    // is called.
    private lateinit var rvBoard : RecyclerView
    private lateinit var tvNumMoves  : TextView
    private lateinit var tvMode : TextView
    private var boardSize : BoardSize = BoardSize.EASY
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the variable by their id.

        rvBoard = findViewById(R.id.rvBoard);
        tvNumMoves = findViewById(R.id.tvNumMoves);
        tvMode = findViewById(R.id.tvMode);

        rvBoard.adapter = MemoryBoardAdapter(this , boardSize)
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager = GridLayoutManager(this , boardSize.getWidth())
    }
}