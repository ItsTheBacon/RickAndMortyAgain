package com.example.rickandmortyagain.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

open class CoroutineViewModel : ViewModel(), CoroutineScope {

    override val coroutineContext = Dispatchers.Main

    private val jobs = ArrayList<Job>()

    override fun onCleared() {
        jobs.forEach { if (!it.isCancelled) it.cancel() }
        super.onCleared()
    }

    fun run(block: () -> Job) {
        jobs.add(block.invoke())
    }

}