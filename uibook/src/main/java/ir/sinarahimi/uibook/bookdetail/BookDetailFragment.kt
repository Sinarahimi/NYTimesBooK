package ir.sinarahimi.uibook.bookdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import ir.sinarahimi.uibook.R

class BookDetailFragment : Fragment(R.layout.fragment_book_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = BookDetailFragment()
    }
}