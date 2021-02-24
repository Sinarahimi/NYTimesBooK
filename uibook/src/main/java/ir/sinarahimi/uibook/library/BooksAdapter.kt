package ir.sinarahimi.uibook.library

import androidx.recyclerview.widget.DiffUtil
import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.presentation.databinding.DataBindingAdapter
import ir.sinarahimi.uibook.R

/**
 * Created by Sina Rahimi on 2/18/2021.
 */
class BooksAdapter : DataBindingAdapter<ModelNYTimes.Book>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<ModelNYTimes.Book>() {
        override fun areItemsTheSame(
            oldItem: ModelNYTimes.Book,
            newItem: ModelNYTimes.Book
        ) = oldItem.title == newItem.title


        override fun areContentsTheSame(
            oldItem: ModelNYTimes.Book,
            newItem: ModelNYTimes.Book
        ) = oldItem == newItem

    }

    override fun getItemViewType(position: Int) = R.layout.item_library
}


