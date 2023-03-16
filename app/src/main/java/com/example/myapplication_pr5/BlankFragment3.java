package com.example.myapplication_pr5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class BlankFragment3 extends Fragment {
    private String fam;
    private  String name;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        fam = getArguments().getString("fam");
        name = getArguments().getString("name");
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_blank3,container,false);
        TextView text1= (TextView) view1.findViewById(R.id.textView11);
        TextView text2 = (TextView) view1.findViewById(R.id.textView17);
        text1.setText(fam);
        text2.setText(name);
        Button button2 = (Button) view1.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameText = (EditText) view1.findViewById(R.id.editTextCar);
                TextView nameText2 = (TextView) view1.findViewById(R.id.textView11);
                TextView nameText1 = (TextView) view1.findViewById(R.id.textView17);
                Bundle bundle = new Bundle();
                bundle.putString("fam", nameText2.getText().toString());
                bundle.putString("name",nameText1.getText().toString());
                bundle.putString("car", nameText.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_blankFragment3_to_blankFragment23,bundle);
            }
        });
        return view1;
    }
}