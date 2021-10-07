package com.example.rickandmortyagain.ui.fragments.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rickandmortyagain.databinding.FragmentCharacterBinding
import com.example.rickandmortyagain.ui.adapters.CharactersAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class CharacterFragment :
    Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    private val viewModel: CharacterViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        setUpRequests()
        return binding.root

    }

    private fun setUpRequests() {
        viewModel.successLiveData.observe(viewLifecycleOwner, {
            Log.e("anime", "setUpRequests: $it")
            binding.rvCharacter.adapter = CharactersAdapter(it)
            Log.e("anime", "setupRequests: $it")
        })
    }
}