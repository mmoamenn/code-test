package com.interview.codetest.presenter.sections.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.interview.codetest.R
import com.interview.codetest.domain.model.Section
import kotlinx.android.synthetic.main.row_item_section.view.*

class SectionAdapter(private val onItemSelected: OnItemSelected) :
    RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    private val items: MutableList<Section> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_item_section, parent, false)
        return SectionViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        with(holder.itemView) {
            val item = items[position]
            sectionTxt.text = item.title
            setOnClickListener {
                onItemSelected.itemClicked(item)
            }
        }
    }

    fun addItems(addedItems: List<Section>) {
        items.clear()
        items.addAll(addedItems)
        notifyDataSetChanged()
    }

    class SectionViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface OnItemSelected {
        fun itemClicked(sectionResponse: Section)
    }

}