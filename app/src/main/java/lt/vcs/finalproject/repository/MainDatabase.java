package lt.vcs.finalproject.repository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import lt.vcs.finalproject.Constants;

@Database(
        entities = {Customer.class, Formula.class, Product.class, Order.class},
        views = {OrderDetails.class},
        version = Constants.MAIN_DATABASE_VERSION,
        exportSchema = false)
@TypeConverters({Converters.class})
public abstract class MainDatabase extends RoomDatabase {

    private static MainDatabase instance;

    public abstract CustomerDao customerDao();
    public abstract FormulaDao formulaDao();
    public abstract ProductDao productDao();
    public abstract OrderDao orderDao();

    public static synchronized MainDatabase getInstance(Context context) {
        if (instance == null) {
            instance =
                    Room.databaseBuilder(
                            context,
                            MainDatabase.class,
                            "main.db"
                    )
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return instance;
    }


}

