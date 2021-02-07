package ir.sinarahimi.uibook.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import ir.sinarahimi.uibook.R

class LibraryFragment : Fragment(R.layout.fragment_library) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = LibraryFragment()
    }
}