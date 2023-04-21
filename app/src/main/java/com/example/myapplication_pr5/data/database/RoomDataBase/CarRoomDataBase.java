package com.example.myapplication_pr5.data.database.RoomDataBase;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.myapplication_pr5.R;
import com.example.myapplication_pr5.data.database.dao.CarDao;
import com.example.myapplication_pr5.data.database.entity.CarEntity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CarEntity.class}, version = 1, exportSchema = false)
public abstract class CarRoomDataBase extends RoomDatabase {
    public abstract CarDao carDao();
    private static volatile CarRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static CarRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CarRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    CarRoomDataBase.class, "car_database")
                            .addCallback(sRoomDatabaseCallback).build();}}
        }
        return INSTANCE;
    }
    public static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                CarDao dao = INSTANCE.carDao();
                dao.deleteAll();
                CarEntity car = new CarEntity(R.drawable.sedan, "Lada Granta");
                dao.insert(car);
                car = new CarEntity(R.drawable.travel, "Niva Travel");
                dao.insert(car);
                car = new CarEntity(R.drawable.vesta, "Lada Vesta");
                dao.insert(car);
                car = new CarEntity(R.drawable.largus, "Lada Largus");
                dao.insert(car);
            });
        }
    };
}
