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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication_pr5.R;
import com.example.myapplication_pr5.ui.adapter.CustomListAdapter;
import com.example.myapplication_pr5.ui.adapter.CustomListAdapter;
import com.example.myapplication_pr5.ui.viewmodel.CarViewModel;


public class BlankFragment5 extends Fragment {
    CarViewModel carViewModel;
    private ListView listview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carViewModel = new ViewModelProvider(this).get(CarViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_blank5,container,false);
        listview = (ListView) view1.findViewById(R.id.listview);
        CustomListAdapter carAdapter = new CustomListAdapter(getContext(), R.layout.cars, carViewModel.cars.getValue());
        listview.setAdapter(carAdapter);
        carViewModel.cars.observe(getViewLifecycleOwner(), cars -> carAdapter.updateCars(cars));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
               Navigation.findNavController(view).navigate(R.id.action_blankFragment5_to_blankFragment3,bundle);
            }
        });
        return view1;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}