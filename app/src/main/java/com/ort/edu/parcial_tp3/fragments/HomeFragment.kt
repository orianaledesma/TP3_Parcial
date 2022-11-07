package com.ort.edu.parcial_tp3.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ort.edu.parcial_tp3.R
import com.ort.edu.parcial_tp3.UserSession
import com.ort.edu.parcial_tp3.adapter.CharacterAdapter
import com.ort.edu.parcial_tp3.api.RickAndMortyService
import com.ort.edu.parcial_tp3.data.CharactersResponse
import com.ort.edu.parcial_tp3.listener.OnCharacterClickedListener
import com.ort.edu.parcial_tp3.model.Character
import com.ort.edu.parcial_tp3.utils.Images
import retrofit2.Call
import retrofit2.Response


/**
 * El Fragment que representa la Home.
 * Implementa interfaz para manejar la selección de los characteros de la lista
 * @see OnCharacterClickedListener
 */
class HomeFragment : Fragment(), OnCharacterClickedListener {
    private lateinit var charactersRecyclerView: RecyclerView
    private lateinit var charactersList:List<Character>
    private lateinit var title: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        charactersRecyclerView = view.findViewById(R.id.character_recyclerview)
        title = view.findViewById(R.id.home_title)

        // Pongo el nombre del usuario en el titulo.
        // Advertencia: Al momento de mostrar un texto al usuario siempre usar un String resource. Nunca hardcodear de
        // esta manera.
        title.text = "Hola, ${UserSession.userName}"
        getCharacters()

    }



    /**
     * Llamada al servicio
     */
    fun getCharacters() {
        val baseURL = getString(R.string.url_api)

        val service = RickAndMortyService.create(baseURL);

        // Lleno una lista con characteros que cree a mano

        service.getListCharacters()?.enqueue(
            object : retrofit2.Callback<CharactersResponse?> {
                override fun onResponse(
                    call: Call<CharactersResponse?>,
                    response: Response<CharactersResponse?>
                ) {
                    if (response.isSuccessful) {
                        val info = response.body()
                        val response: CharactersResponse? = (info as CharactersResponse)!!
                        Log.e("Example", response.toString())
                        Snackbar.make(charactersRecyclerView, "Metodo ondCreate", Snackbar.LENGTH_LONG).show()
                        charactersList = (response?.result as List<Character>).toMutableList()
                        fillcharactersList()
                    }
                }
                override fun onFailure(call: Call<CharactersResponse?>, t: Throwable) {
                    Log.e("Example", t.stackTraceToString())
                }
            })
    }
    /**
     * Cargo los characteros que voy a usar para mostrar en la lista de la home
     */
    private fun fillcharactersList() {

        // Configuro el recyclerview y le paso un Adapter
        val layoutManager = LinearLayoutManager(context)
        charactersRecyclerView.layoutManager = layoutManager
        charactersRecyclerView.adapter = CharacterAdapter(charactersList, this)
    }

    /**
     * Como esta clase implementa OnProductClickedListener, entonces tengo que implementar este metodo, donde voy
     * a navegar hacia el fragemnt de detalle de charactero pasando como argumento el charactero que seleccione
     * @param character Producto seleccionado de la lista
     */
    override fun onCharacterSelected(character: Character) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCharacterDetailFragment(character))
    }
}