package com.example.myapplication_pr5.ui.fragment;

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


public class BlankFragment extends Fragment {

    static final private String TAG = "FirstFr";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_blank, container, false);
        SharedPreferences sharedPreferences;
        sharedPreferences = getActivity().getSharedPreferences("name",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String famil = sharedPreferences.getString("fam",null);
        String name = sharedPreferences.getString("name",null);
        Button but = (Button) view1.findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameText = (EditText) view1.findViewById(R.id.editTextTextPersonName);
                EditText nameText1 = (EditText) view1.findViewById(R.id.editTextTextPersonName2);
                editor.putString("fam", nameText1.getText().toString());
                editor.putString("name", nameText.getText().toString());
                editor.apply();
                Bundle bundle = new Bundle();
                bundle.putString("fam", nameText.getText().toString());
                bundle.putString("name", nameText1.getText().toString());
                String text = nameText.getText().toString();
                String text1 = nameText1.getText().toString();
                String fileName = "userName.txt";
                //Запись файла в app-specific storage
                createFileAppScecificStorage(fileName, text, text1);
                //Запись файла в общем хранилище
                createFileExternalStorage(fileName, text, text1);
                Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_blankFragment23, bundle);
            }
        });


        return view1;
    }


    void createFileAppScecificStorage(String fileName, String text, String text1) {
        Context context = getContext();
        try (FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE)) {
            fos.write(text.getBytes());
            fos.write(text1.getBytes());
            Toast.makeText(context, "Текстовый файл  " + context.getDataDir().getAbsolutePath() + "/" + fileName, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void createFileExternalStorage(String fileName, String text, String text1) {
        Context context = getContext();
        if (context.getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(filePath, fileName);
            FileOutputStream outputStream;
            try {
                outputStream = new FileOutputStream(file);
                outputStream.write(text.getBytes());
                outputStream.write(text1.getBytes());
                Toast.makeText(context, "Текстовый файл" + filePath +"/"+ fileName, Toast.LENGTH_SHORT).show();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},1 );
        }
    }
}