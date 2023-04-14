package com.example.myapplication_pr5.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication_pr5.R;


public class BlankFragment4 extends Fragment {

    private String fam;
    private  String name;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fam = getArguments().getString("fam");
        name = getArguments().getString("name");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_blank4,container,false);
        TextView text1= (TextView) view1.findViewById(R.id.textView8);
        TextView text2 = (TextView) view1.findViewById(R.id.textView13);
        text1.setText(fam);
        text2.setText(name);
        Button button = view1.findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView nameText = (TextView) view1.findViewById(R.id.textView8);
                TextView nameText2 = (TextView) view1.findViewById(R.id.textView13);
                Bundle bundle = new Bundle();
                bundle.putString("fam", nameText.getText().toString());
                bundle.putString("name", nameText2.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_blankFragment4_to_blankFragment2,bundle);
            }
        });
        return view1;
    }
}