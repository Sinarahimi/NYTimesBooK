package ir.sinarahimi.uibook.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.presentation.Event
import ir.sinarahimi.presentation.base.BaseFragment
import ir.sinarahimi.presentation.showSnackbar
import ir.sinarahimi.uibook.databinding.FragmentLibraryBinding
import javax.inject.Inject

class LibraryFragment : BaseFragment() {

    private var binding: FragmentLibraryBinding? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val booksAdapter: BooksAdapter by lazy {
        BooksAdapter()
    }

    private val viewModel: LibraryViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LibraryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.libraryRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = adapter
        }

        binding!!.swipeRefreshLayout.apply {
            isRefreshing = true
            setOnRefreshListener(::onRefresh)
        }
        viewModel.refreshEvent.observe(viewLifecycleOwner, ::onGetBooks)
        viewModel.errorEvent.observe(viewLifecycleOwner, ::onError)
    }

    private fun onError(event: Event<Int>?) {
        binding!!.root.showSnackbar("Something Bad Happened!")
    }

    private fun onGetBooks(event: Event<List<ModelNYTimes.Book>>?) {
        event?.getContentIfNotHandled().let {
            binding!!.swipeRefreshLayout.isRefreshing = false
            booksAdapter.submitList(it)
        }
    }

    private fun onRefresh() {
        viewModel.refresh()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = LibraryFragment()
    }
}