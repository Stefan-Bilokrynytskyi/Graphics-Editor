package com.example.lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.CanvasShape.Companion.currentInd
import com.example.lab3.MainActivity.Companion.figures
import com.example.lab3.databinding.RecyclerElemBinding
import com.example.lab3.figures.Shape

class ElemAdapter: RecyclerView.Adapter<ElemAdapter.ElemHolder>() {

    class ElemHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = RecyclerElemBinding.bind(item)
        fun bind(shape: Shape) = with(binding) {
            textView.text = shape.getCoordinates()
            checkBox.isChecked = shape.selected
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_elem, parent, false)
        return ElemHolder(view)
    }

    override fun onBindViewHolder(holder: ElemHolder, position: Int) {
        holder.bind(figures[holder.adapterPosition])
        val checkBox = holder.binding.checkBox
        checkBox.setOnClickListener {
            figures[holder.adapterPosition].selected = !figures[holder.adapterPosition].selected
            checkBox.isChecked = figures[holder.adapterPosition].selected
        }

        holder.binding.buttonDel.setOnClickListener {
            figures.removeAt(holder.adapterPosition)
            currentInd--
            notifyItemRemoved(holder.adapterPosition)

        }
    }

    override fun getItemCount(): Int {
        return figures.size
    }
}