package com.trickring.app_mvvm_usecase.ui.post

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.trickring.app_mvvm_usecase.R
import com.trickring.app_mvvm_usecase.ext.groupAdapter
import com.trickring.app_mvvm_usecase.ext.setGroupOnItemClickListener
import com.trickring.app_mvvm_usecase.ui.component.RecyclerViewStatefulObserver
import com.trickring.app_mvvm_usecase.ui.post.item.PostItem
import kotlinx.android.synthetic.main.fragment_post.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

/**
 * Post List Screen. [Fragment] subclass.
 */
class PostFragment : Fragment(R.layout.fragment_post) {

    /**
     * Post List Screen's ViewModel
     */
    private val viewModel: PostViewModel by viewModel()

    // region Lifecycle

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        bindInput()
        bindOutput()
    }

    // endregion

    /**
     * View initial settings
     */
    private fun initialize() {
        recyclerView.adapter = groupAdapter.apply {
            setGroupOnItemClickListener<PostItem> { item, _ ->
                findNavController().navigate(PostFragmentDirections.actionToPostDetail(item.post))
            }
        }
    }

    /**
     * Instruction from View to ViewModel
     */
    private fun bindInput() {
    }

    /**
     * Instruction from ViewModel to View
     */
    private fun bindOutput() {
        val observer = RecyclerViewStatefulObserver(recyclerView, emptyView, progressBar)
        viewModel.posts.observe(viewLifecycleOwner, Observer { result ->
            result.onSuccess {
                val items = PostItem.from(it)
                recyclerView.groupAdapter?.update(items)
                observer.invalidate()
            }
            result.onFailure {
                Timber.e(it)
            }
        })
    }
}
