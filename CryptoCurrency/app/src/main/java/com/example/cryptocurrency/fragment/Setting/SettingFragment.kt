package com.example.cryptocurrency.fragment.Setting

import PrivacyFragment
import UserFragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cryptocurrency.R
import com.example.cryptocurrency.activity.LoginActivity
import com.example.cryptocurrency.databinding.SettingBinding

class SettingFragment : Fragment() {

    private var _binding: SettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SettingBinding.inflate(inflater, container, false)


        // Logic cho các button khác nếu cần thiết

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userButton = view.findViewById<Button>(R.id.btnUser)
        val privacyButton = view.findViewById<Button>(R.id.btnPrivacy)
        val logoutButton = view.findViewById<Button>(R.id.btnSignOut)

        userButton.setOnClickListener {
            val userFragment = UserFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, userFragment) // Replace with your container ID
                .addToBackStack(null)
                .commit()
        }

        privacyButton.setOnClickListener {
            val privacyFragment = PrivacyFragment() // Make sure PrivacyFragment is defined
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, privacyFragment) // Replace with your container ID
                .addToBackStack(null)
                .commit()
        }
        logoutButton.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            activity?.finish() // Optionally finish the current activity to clear it from the back stack
        }
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
