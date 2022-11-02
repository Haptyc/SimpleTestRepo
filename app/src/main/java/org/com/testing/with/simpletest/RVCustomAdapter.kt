package org.com.testing.with.simpletest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

/**
 * TODO: Implement the Adapter that will populate a RecyclerView using the information generated in ViewModel
 * */

class RVCustomAdapter(private val lstRes: MutableList<Article> = mutableListOf()) :
    RecyclerView.Adapter<RVCustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.mImageViewCardViewItem)
        val textViewTitle: TextView = view.findViewById(R.id.mTextViewTitle)
        val textViewContent: TextView = view.findViewById(R.id.mTextViewContent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        lstRes[position].let {
            Picasso.get().load(it.imageURL).into(holder.imageView)
            holder.textViewTitle.text = it.title
            holder.textViewContent.text = it.content
        }
    }


    override fun getItemCount(): Int {
        return lstRes.size
    }

    fun updateData(list: List<Article>?) {
        list?.let {
            lstRes.addAll(it)
            notifyItemRangeInserted(0,it.size)
        }

    }


}