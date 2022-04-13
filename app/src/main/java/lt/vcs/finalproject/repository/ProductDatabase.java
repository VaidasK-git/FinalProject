package lt.vcs.finalproject.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import lt.vcs.finalproject.Constants;

@Database(
        entities = {Product.class},
        version = Constants.MAIN_DATABASE_VERSION,
        exportSchema = false)

public abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
