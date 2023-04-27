package com.example.myapplication_pr5.ui.fragment;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.Manifest;
import com.example.myapplication_pr5.R;
import com.example.myapplication_pr5.data.datasource.CarSource;
import com.example.myapplication_pr5.ui.viewmodel.CarViewModel;
import com.example.myapplication_pr5.ui.viewmodel.UserModel;


public class BlankFragment extends Fragment {

    static final private String TAG = "FirstFr";
    UserModel userModel = new UserModel();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_blank, container, false);
        Button but = (Button) view1.findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameText = (EditText) view1.findViewById(R.id.editTextTextPersonName);
                EditText nameText1 = (EditText) view1.findViewById(R.id.editTextTextPersonName2);
                Bundle bundle = new Bundle();
                bundle.putString("fam", nameText.getText().toString());
                bundle.putString("name", nameText1.getText().toString());
                String text = nameText.getText().toString();
                String text1 = nameText1.getText().toString();
                userModel.createFileSharedPreferences(getContext(),"Users.txt", text, text1);
                userModel.createFileExternalStorage(requireActivity(),"Users.txt", text, text1);
                userModel.createFileAppScecific(getContext(), "Users",text,text1);


                Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_blankFragment23, bundle);
            }
        });


        return view1;
    }



}