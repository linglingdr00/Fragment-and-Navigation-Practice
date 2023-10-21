package com.example.myfragtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myfragtest.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

    // 引用(reference) fragment_one layout
    private var _binding: FragmentTwoBinding? = null
    // 建立 binding
    private val binding get() = _binding!!
    // 建立 linerView
    private lateinit var linerView: LinearLayout
    // 建立 myText
    private lateinit var myText: String
    private lateinit var textView: TextView

    /* 透過 DetailActivity.<variable> 從 app 中的任何位置提供對這些變數的全域訪問，
       而無需建立 DetailActivity instance */
    companion object {
        const val showMyText = "showText"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 傳入 showText 參數，並設為 myText
        arguments?.let {
            myText = it.getString(showMyText).toString()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTwoBinding.inflate(inflater, container, false)
        // 傳回 root view
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 設定 linerView
        linerView = binding.linerView
        // 設定 textView
        textView = binding.myTextView

        // 設定 textView 文字為傳入的 myText
        textView.setText(myText)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // 將 _binding 屬性重設為 null，因為 view 已不存在
        _binding = null
    }
}