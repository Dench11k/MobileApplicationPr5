package com.example.myapplication_pr5.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication_pr5.R;


public class BlankFragment extends Fragment {

    static final private String TAG = "FirstFr";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_blank,container,false);
        Button but = (Button) view1.findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameText = (EditText) view1.findViewById(R.id.editTextTextPersonName);
                EditText nameText1 = (EditText) view1.findViewById(R.id.editTextTextPersonName2);
                Bundle bundle = new Bundle();
                bundle.putString("fam", nameText.getText().toString());
                bundle.putString("name",nameText1.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_blankFragment23, bundle);
            }
        });


        return view1;
    }
}