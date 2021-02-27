package ir.sinarahimi.uibook.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.sinarahimi.domain.ModelNYTimes.Book
import ir.sinarahimi.uibook.databinding.ItemLibraryBinding

/**
 * Created by Sina Rahimi on 2/18/2021.
 */
class BooksAdapter : ListAdapter<Book, BooksAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(
        private val itemLibraryBinding: ItemLibraryBinding
    ) : RecyclerView.ViewHolder(itemLibraryBinding.root) {

        fun bind(book: Book) {
            itemLibraryBinding.book = book
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLibraryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(
        oldItem: Book,
        newItem: Book
    ) = oldItem.title == newItem.title

    override fun areContentsTheSame(
        oldItem: Book,
        newItem: Book
    ) = oldItem == newItem
}


