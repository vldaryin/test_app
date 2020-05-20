package com.example.android.features.lessons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.android.common.base.BaseFragment
import com.example.android.common.base.BaseViewModel
import com.example.android.features.lessons.databinding.FragmentLessonsBinding
import com.example.android.features.lessons.views.LessonsAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class LessonsFragment : BaseFragment() {

    private val viewModel: LessonsViewModel by viewModel()
    private lateinit var binding: FragmentLessonsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLessonsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureRecyclerView()
    }

    override fun getViewModel(): BaseViewModel = viewModel

    // ---

    private fun configureRecyclerView() {
        binding.lessonsRecyclerView.adapter = LessonsAdapter(viewModel)
        viewModel.lessons.observe(viewLifecycleOwner, Observer {
            binding.lessonsRecyclerView.smoothScrollToPosition(0)
        })
    }
}