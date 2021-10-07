package com.example.rickandmortyagain.ui.fragments.character

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyagain.models.Info
import com.example.rickandmortyagain.ui.useCase.RickAndMortyUseCase
import com.example.rickandmortyagain.utils.CoroutineViewModel
import kotlinx.coroutines.launch

class CharacterViewModel(private val useCase: RickAndMortyUseCase) : CoroutineViewModel() {

    var successLiveData = MutableLiveData<List<Info>>()
    var errorLiveData = MutableLiveData<String>()
    var loadLiveData = MutableLiveData<Boolean>()

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() = run {
        loadLiveData.value = true
        viewModelScope.launch {
            try {
                Log.e("anime", "getCharacterAssync: ${useCase.getCharacterAsync().await()}")
                successLiveData.value = useCase.getCharacterAsync().await()
            } catch (ex: Exception) {
                Log.e("anime", "error: ${ex.localizedMessage}")
//                errorLiveData.value = ex.localizedMessage
            } finally {
                loadLiveData.value = false
            }
        }
    }

}