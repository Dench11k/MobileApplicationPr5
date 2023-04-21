package com.example.myapplication_pr5.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication_pr5.R;
import com.example.myapplication_pr5.data.model.Car;
import com.example.myapplication_pr5.ui.adapter.CustomListAdapter;
import com.example.myapplication_pr5.ui.adapter.CustomListAdapter;
import com.example.myapplication_pr5.ui.adapter.MyCustomListAdapter;
import com.example.myapplication_pr5.ui.viewmodel.CarViewModel;


public class BlankFragment5 extends Fragment {
    CarViewModel carViewModel;
    RecyclerView recyclerView;
    MyCustomListAdapter myCustomListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carViewModel = new ViewModelProvider(this).get(CarViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_blank5,container,false);
        recyclerView = view1.findViewById(R.id.recyclerView);
        myCustomListAdapter = new MyCustomListAdapter();
        Bundle args = getArguments();
        if (args != null && args.containsKey("RESULT_OK_NAME") && args.containsKey("RESULT_OK_IMG")) {
            Car car = new Car(args.getInt("RESULT_OK_IMG"), args.getString("RESULT_OK_NAME"));
            carViewModel.insert(car);
        }
        Button button = view1.findViewById(R.id.button25);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Navigation.findNavController(view).navigate(R.id.action_blankFragment5_to_blankFragment6);
                                      }
                                  });
                recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myCustomListAdapter);// установка адаптера
        carViewModel.getAllCars().observe(getViewLifecycleOwner(), cars ->
                myCustomListAdapter.updateBooks(cars));

        return view1;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}