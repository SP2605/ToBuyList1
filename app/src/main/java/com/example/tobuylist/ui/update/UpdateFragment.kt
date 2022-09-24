package com.example.tobuylist.ui.update

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tobuylist.R
import com.example.tobuylist.database.TaskEntry
import com.example.tobuylist.databinding.FragmentUpdateBinding
import com.example.tobuylist.viewmodel.TaskViewModel


class UpdateFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentUpdateBinding.inflate(inflater)

        val args = UpdateFragmentArgs.fromBundle(requireArguments())

        binding.apply {
            updateEdtTsk.setText(args.taskEntry.title)
            updateSpinner.setSelection(args.taskEntry.priority)
            
            btnUpdate.setOnClickListener {
                if(TextUtils.isEmpty(updateEdtTsk.text)){
                    Toast.makeText(requireContext(), "It's empty", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val task_str = updateEdtTsk.text
                val priority = updateSpinner.selectedItemPosition

                val taskEntry = TaskEntry (
                    args.taskEntry.id,
                    task_str.toString(),
                    priority,
                    args.taskEntry.timestamp
                )

                viewModel.update(taskEntry)
                Toast.makeText(requireContext(), "Updated!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_updateFragment_to_taskFragment)
            }
        }
        return binding.root
    }


}