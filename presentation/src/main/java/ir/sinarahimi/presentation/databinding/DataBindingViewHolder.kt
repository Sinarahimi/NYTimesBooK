package ir.sinarahimi.presentation.databinding

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ir.sinarahimi.presentation.BR

/**
 * Created by Sina Rahimi on 2/20/2021.
 */
class DataBindingViewHolder<T>(
    private val viewDataBinding: ViewDataBinding
    ) :RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(item:T){
            viewDataBinding.setVariable(BR._all,item)
            viewDataBinding.executePendingBindings()
        }
}