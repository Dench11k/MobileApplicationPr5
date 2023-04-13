package com.example.myapplication_pr5;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
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
    private static final int NOTIFY_ID = 101;
    private static String CHANNEL_ID = "Car channel";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Channel 2";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getContext().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
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
                NotificationCompat.Builder builder = new
                        NotificationCompat.Builder(getContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle(getString(
                                R.string.text_name_5))
                        .setContentText("Автомобиль успешно забронирован!")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                    notificationManager.notify(NOTIFY_ID, builder.build());
                }
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