package com.example.myslideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myslideshow.databinding.FragmentImageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val IMG_RES_ID = "IMG_RES_ID"

/**
 * A simple [Fragment] subclass.
 * Use the [ImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImageFragment : Fragment() {

    private var imageResId: Int? = null

    /**
     * Bundleオブジェクトから画像リソースIDを取得する
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageResId = it.getInt(IMG_RES_ID)
        }
    }

    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    /**
     * viewBindingの設定
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * 画像リソースIDを保存する
         *
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(imageResId: Int) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putInt(IMG_RES_ID, imageResId)
                }
            }
    }

    /**
     * 取得した画像リソースIDをimageViewにセット
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageResId?.let {
            binding.imageView.setImageResource(it)
        }
    }
}