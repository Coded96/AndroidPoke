package com.example.conversor.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.conversor.R
import com.example.conversor.entities.Jugador

class SquirtleFragment : Fragment() {
    private var listener: OnSquirtleFragmentActionListener? = null
    private var entrenador: Jugador? = null
    lateinit var txtPokeName: TextView
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val vista: View = inflater.inflate(R.layout.fragment_squirtle, container, false)

        if(vista != null){
            try{
                txtPokeName = vista.findViewById(R.id.txtSquirtleName)
            }catch(ex:Exception){
                print("ERROR en onCreateView siendo vista != null - ${ex.message}")
            }
        }
        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try{
            arguments.let { entrenador = it!!.getParcelable("entrenador") }


            if(entrenador != null) {
                txtPokeName.text = txtPokeName.text.toString().replace("[POKE_NAME]", entrenador!!.Pokemones[0].Name.toString())
            }
        }catch(ex:Exception){
            print("ERROR en onViewCreated ${ex.message}")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSquirtleFragmentActionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        @JvmStatic
        fun newInstance(entrenador: Jugador?): SquirtleFragment =
            SquirtleFragment().apply {
                return try{
                    val fragment = SquirtleFragment()
                    val args = Bundle()
                    args.putParcelable("entrenador", entrenador)
                    fragment.arguments = args
                    fragment
                }catch(ex:Exception){
                    print("ERROR al crear nueva instacia ${ex.message}")
                    this
                }
            }
    }
    interface OnSquirtleFragmentActionListener {
        fun onSquirtleClickFragmentButton()
    }
}