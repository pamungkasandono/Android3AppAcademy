package com.pamungkasandono.android3appacademy.ui.reader.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pamungkasandono.android3appacademy.data.ModuleEntity
import com.pamungkasandono.android3appacademy.databinding.FragmentModuleListBinding
import com.pamungkasandono.android3appacademy.ui.reader.CourseReaderActivity
import com.pamungkasandono.android3appacademy.ui.reader.CourseReaderCallback
import com.pamungkasandono.android3appacademy.ui.reader.CourseReaderViewModel

class ModuleListFragment : Fragment(), MyAdapterClickListener {

    companion object {
        val TAG: String = ModuleListFragment::class.java.simpleName
        fun newInstance(): ModuleListFragment = ModuleListFragment()
    }

    private lateinit var fragmentModuleListBinding: FragmentModuleListBinding
    private lateinit var adapter: ModuleListAdapter
    private lateinit var courseReaderCallback: CourseReaderCallback

    private lateinit var viewModel: CourseReaderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentModuleListBinding = FragmentModuleListBinding.inflate(inflater, container, false)
        return fragmentModuleListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.NewInstanceFactory()
        )[CourseReaderViewModel::class.java]
        adapter = ModuleListAdapter(this)
        populateRecyclerView(viewModel.getModules())
        Toast.makeText(context, "opend", Toast.LENGTH_SHORT).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }

    // onItemClicked di pake
    override fun onItemClicked(position: Int, moduleId: String) {
        // moveTo di set
        courseReaderCallback.moveTo(position, moduleId)
        viewModel.setSelectedModule(moduleId)
        Toast.makeText(context, "1111111111111111111111111111", Toast.LENGTH_SHORT).show()
    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        Log.d("asdasd getModules", modules.toString())
        with(fragmentModuleListBinding) {
            progressBar.visibility = View.GONE
            adapter.setModules(modules)
            rvModule.layoutManager = LinearLayoutManager(context)
            rvModule.setHasFixedSize(true)
            rvModule.adapter = adapter
            val dividerItemDecoration =
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            rvModule.addItemDecoration(dividerItemDecoration)
        }

    }

}