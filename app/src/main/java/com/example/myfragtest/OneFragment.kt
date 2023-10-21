package com.example.myfragtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myfragtest.databinding.FragmentOneBinding

class OneFragment : Fragment() {

    // 引用(reference) fragment_one layout
    private var _binding: FragmentOneBinding? = null
    // 建立 binding
    private val binding get() = _binding!!
    // 建立 linerView
    private lateinit var linerView: LinearLayout
    // 建立
    private lateinit var to_two_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        // 傳回 root view
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 設定 linerView
        linerView = binding.linerView

        setButtonAction()
    }

    private fun setButtonAction() {
        to_two_button = binding.toTwoButton
        to_two_button.setOnClickListener {
            val action = OneFragmentDirections.actionOneFragmentToTwoFragment(showText = "success")
            view?.findNavController()?.navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // 將 _binding 屬性重設為 null，因為 view 已不存在
        _binding = null
    }

}