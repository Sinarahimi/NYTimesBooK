package ir.sinarahimi.uibook.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.sinarahimi.domain.ModelNYTimes.Book
import ir.sinarahimi.uibook.databinding.ListItemLibraryBinding

/**
 * Created by Sina Rahimi on 2/18/2021.
 */
class BooksAdapter : ListAdapter<Book, BooksAdapter.ViewHolder>(DiffCallback) {

    object DiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(
            oldItem: Book,
            newItem: Book
        ) = oldItem.title == newItem.title

        override fun areContentsTheSame(
            oldItem: Book,
            newItem: Book
        ) = oldItem == newItem
    }

    class ViewHolder(
        private val itemLibraryBinding: ListItemLibraryBinding
    ) : RecyclerView.ViewHolder(itemLibraryBinding.root) {

        fun bind(book: Book) {
            itemLibraryBinding.book = book
            itemLibraryBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemLibraryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}




