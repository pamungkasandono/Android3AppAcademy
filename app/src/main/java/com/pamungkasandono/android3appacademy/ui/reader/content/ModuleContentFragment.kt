package com.pamungkasandono.android3appacademy.ui.reader.content

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pamungkasandono.android3appacademy.data.ContentEntity
import com.pamungkasandono.android3appacademy.data.ModuleEntity
import com.pamungkasandono.android3appacademy.databinding.FragmentModuleContentBinding
import com.pamungkasandono.android3appacademy.ui.reader.CourseReaderViewModel

class ModuleContentFragment : Fragment() {
    companion object {
        val TAG: String = ModuleContentFragment::class.java.simpleName
        fun newInstance(): ModuleContentFragment = ModuleContentFragment()
    }

    private lateinit var fragmentModuleContentBinding: FragmentModuleContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentModuleContentBinding =
            FragmentModuleContentBinding.inflate(inflater, container, false)
        return fragmentModuleContentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(
                requireActivity(),
                ViewModelProvider.NewInstanceFactory()
            )[CourseReaderViewModel::class.java]
            val module = viewModel.getSelectedModule()
            //val content =
            //  ContentEntity("<h3 class=\\\\\\\"fr-text-bordered\\\\\\\">Contoh Content</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>")
//            populateWebView(content)
            Toast.makeText(activity, "viewvreate ", Toast.LENGTH_SHORT).show()
            populateWebView(module)
        }
    }

    private fun populateWebView(content: ContentEntity) {
        Log.d("asdasd cek", "popwebview")
        fragmentModuleContentBinding.webView.loadData(
            content.content ?: "",
            "text/html",
            "UTF-8"
        )
    }

    private fun populateWebView(module: ModuleEntity) {
        fragmentModuleContentBinding.webView.loadData(
            module.contentEntity?.content
                ?: "", "text/html", "UTF-8"
        )
    }
}