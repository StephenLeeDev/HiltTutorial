package com.stephen.hilttutorial

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.stephen.hilttutorial.data.NoteViewModel
import com.stephen.hilttutorial.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val noteViewModel : NoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            saveBtn.setOnClickListener {
                noteViewModel.saveNote(
                    title = noteTitle.text.toString(),
                    description = noteDescription.text.toString()
                )
            }

            noteViewModel.note.observe(this@MainActivity) {
                noteTitle.setText(it.title)
                noteDescription.setText(it.description)
            }
        }
    }
}