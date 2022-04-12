package lt.vcs.finalproject.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import lt.vcs.finalproject.Constants;
import lt.vcs.finalproject.repository.Customer;
import lt.vcs.finalproject.repository.CustomerDao;

@Database(
        entities = {Customer.class},
        version = Constants.MAIN_DATABASE_VERSION,
        exportSchema = false)

public abstract class CustomerDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();
}

