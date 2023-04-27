package com.example.myapplication_pr5.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication_pr5.R;

import org.jetbrains.annotations.Nullable;


public class BlankFragment6 extends Fragment {
    public BlankFragment6() {
        super(R.layout.fragment_blank6);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank6, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button buttonUpload = view.findViewById(R.id.buttonUpload);
        EditText editTextName = view.findViewById(R.id.editTextCar);
        buttonUpload.setOnClickListener(v -> {
            String carName = editTextName.getText().toString();
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(carName) ) {
                editTextName.setError(null);
                bundle.putString("RESULT_OK_NAME",carName);
                bundle.putInt("RESULT_OK_IMG", R.drawable.fon);
                Navigation.findNavController(view).navigate(R.id.action_blankFragment6_to_blankFragment5, bundle);
            }
            else if (TextUtils.isEmpty(carName)) {
                editTextName.setError("Пустая строка!");
            }
            else
            {
                editTextName.setError("Пустая строка!");
            }
        });
    }
}