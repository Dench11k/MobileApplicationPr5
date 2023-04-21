package com.example.myapplication_pr5.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication_pr5.R;
import com.example.myapplication_pr5.data.model.Car;
import com.example.myapplication_pr5.ui.adapter.CustomListAdapter;
import com.example.myapplication_pr5.ui.viewmodel.CarViewModel;

import java.util.ArrayList;


public class BlankFragment2 extends Fragment {
    private String fam;
    private  String name;
    CarViewModel carViewModel;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fam = getArguments().getString("fam");
        name = getArguments().getString("name");
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_blank2,container,false);
        TextView text1= (TextView) view1.findViewById(R.id.textView9);
        TextView text2 = (TextView) view1.findViewById(R.id.textView10);
        text1.setText(fam);
        text2.setText(name);
        Bundle bundle1 = getArguments();
        if(bundle1 != null) {
            TextView text = (TextView) view1.findViewById(R.id.textView20);
            text.setText(getArguments().getString("car"));
            TextView text3 = (TextView) view1.findViewById(R.id.textView9);
            text3.setText(getArguments().getString("fam"));
            TextView text4 = (TextView) view1.findViewById(R.id.textView10);
            text4.setText(getArguments().getString("name"));
        }
        Button button3 = (Button) view1.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView nameText = (TextView) view1.findViewById(R.id.textView9);
                TextView nameText1 = (TextView) view1.findViewById(R.id.textView10);
                Bundle bundle = new Bundle();
                bundle.putString("fam", nameText.getText().toString());
                bundle.putString("name",nameText1.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_blankFragment2_to_blankFragment33, bundle);
            }
        });
        ImageView imageView = view1.findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView nameText = (TextView) view1.findViewById(R.id.textView9);
                TextView nameText1 = (TextView) view1.findViewById(R.id.textView10);
                Bundle bundle = new Bundle();
                bundle.putString("fam", nameText.getText().toString());
                bundle.putString("name",nameText1.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_blankFragment2_to_blankFragment4, bundle);
            }
        });
        return view1;
    }


}