package com.example.latihan_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnmul = view.findViewById<Button>(R.id.btnMul)
        val btndiv = view.findViewById<Button>(R.id.btnDiv)

        val angka1 = requireActivity().findViewById<EditText>(R.id.angka1)
        val angka2 = requireActivity().findViewById<EditText>(R.id.angka2)

        btnmul.setOnClickListener {
            val num1 = angka1.text.toString().toInt()
            val num2 = angka2.text.toString().toInt()

            val calculate = num1*num2

            val fragmenthasil = hasil()
            val datakirim = Bundle().apply {
                putString("HasilOperasi",calculate.toString())
            }
            fragmenthasil.arguments = datakirim

            replaceFragment(fragmenthasil)
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentmanager = parentFragmentManager
        val fragmentransaction = fragmentmanager.beginTransaction()

        fragmentransaction.replace(R.id.fragment_container2,fragment)
        fragmentransaction.addToBackStack(null)
        fragmentransaction.commit()
    }
}