package jp.co.yumemi.android.codeCheck.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import jp.co.yumemi.android.codeCheck.R
import jp.co.yumemi.android.codeCheck.domain.Stargazer

val stargazersDiffUtil = object : DiffUtil.ItemCallback<Stargazer>() {
    override fun areItemsTheSame(oldItem: Stargazer, newItem: Stargazer): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Stargazer, newItem: Stargazer): Boolean {
        return oldItem == newItem
    }
}

class StargazersAdapter(
    private val itemClickAction: OnItemClickListener,
) : ListAdapter<Stargazer, StargazersAdapter.ViewHolder>(stargazersDiffUtil) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface OnItemClickListener {
        fun itemClick(item: Stargazer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        (holder.itemView.findViewById<ImageView>(R.id.repository_image)).load(item.avatarUrl) {
            R.drawable.jetbrains
        }

        (holder.itemView.findViewById<TextView>(R.id.repository_text)).text =
            item.userName

        holder.itemView.setOnClickListener {
            itemClickAction.itemClick(item)
        }
    }
}
