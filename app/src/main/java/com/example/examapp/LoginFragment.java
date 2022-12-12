package com.example.examapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examapp.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button2.setOnClickListener(view1 -> {
            final String email = binding.editTextTextEmailAddress2.getText().toString();
            final String password = binding.editTextTextPassword2.getText().toString();

            if (email.equals("admin") & password.equals("admin")) {
                return;
            }

            binding.editTextTextEmailAddress2.setText("Wrong e-mail");
            binding.editTextTextPassword2.setText("Wrong password");
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}