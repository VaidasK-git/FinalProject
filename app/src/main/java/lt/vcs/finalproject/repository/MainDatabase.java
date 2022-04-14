package lt.vcs.finalproject.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import lt.vcs.finalproject.Constants;

@Database(
        entities = {Customer.class, Formula.class, Product.class, Order.class},
        version = Constants.MAIN_DATABASE_VERSION,
        exportSchema = false)
@TypeConverters({Converters.class})
public abstract class MainDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();
    public abstract FormulaDao formulaDao();
    public abstract ProductDao productDao();
    public abstract OrderDao orderDao();
}

