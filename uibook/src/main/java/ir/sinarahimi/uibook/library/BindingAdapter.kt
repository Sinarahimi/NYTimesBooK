package ir.sinarahimi.uibook.library

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Created by Sina Rahimi on 3/1/2021.
 */
@BindingAdapter("loadImageGlide")
fun ImageView.loadImageGlide(imageUrl: String) {
    Glide.with(context)
        .load(imageUrl)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}