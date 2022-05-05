package lt.vcs.finalproject.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import lt.vcs.finalproject.Constants;

@Database(
        entities = {Customer.class, Formula.class, Product.class, Order.class},
        views = {OrderDetails.class},
        version = Constants.MAIN_DATABASE_VERSION,
        exportSchema = false)
@TypeConverters({Converters.class})
public abstract class MainDatabase extends RoomDatabase {

    private static MainDatabase instance;
    private static final int newVersionDb = Constants.MAIN_DATABASE_VERSION;
    private static final int previousVersionDb = newVersionDb - 1;

    public abstract CustomerDao customerDao();
    public abstract FormulaDao formulaDao();
    public abstract ProductDao productDao();
    public abstract OrderDao orderDao();
    public abstract OrderDetailsDao orderDetailsDao();

    public static synchronized MainDatabase getInstance(Context context) {
        if (instance == null) {
            instance =
                    Room.databaseBuilder(
                            context,
                            MainDatabase.class,
                            "main.db"
                    )
                            .addMigrations(MIGRATION_1_2)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return instance;
    }

    private static final Migration MIGRATION_1_2 = new Migration(
            previousVersionDb,
            newVersionDb
    ) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };


}

