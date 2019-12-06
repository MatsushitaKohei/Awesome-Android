package com.trickring.app_mvvm_usecase.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.trickring.app_mvvm_usecase.R
import kotlinx.android.synthetic.main.fragment_post_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Post Detail Screen. [Fragment] subclass.
 */
class PostDetailFragment : Fragment() {

    /**
     * Arguments
     */
    private val args: PostDetailFragmentArgs by navArgs()

    /**
     * ViewModel
     */
    private val viewModel: PostDetailViewModel by viewModel()

    // region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.init(args)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_detail, container, false)
    }

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
        title.text = args.post.title
        body.text = args.post.body
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
    }
}
