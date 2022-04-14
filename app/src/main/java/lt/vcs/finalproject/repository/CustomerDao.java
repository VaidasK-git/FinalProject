package lt.vcs.finalproject.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import lt.vcs.finalproject.Constants;

@Dao
public interface CustomerDao {

    @Query("SELECT * FROM " + Constants.ENTITY_CUSTOMERS_TABLE)
    List<Customer> getAll();

    @Query("SELECT * FROM " + Constants.ENTITY_CUSTOMERS_TABLE + " WHERE customerId =:customerId")
    Customer getItem(int customerId);

    @Query("SELECT MAX(customerId) FROM " + Constants.ENTITY_CUSTOMERS_TABLE)
    Integer getMaxCustomerId();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCustomers(List<Customer> customers);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCustomer(Customer customer);

    @Delete
    void deleteCustomers(List<Customer> customers);

    @Delete
    void deleteCustomer(Customer customer);

    @Query("DELETE FROM " + Constants.ENTITY_CUSTOMERS_TABLE+ " WHERE customerId =:customerId")
    void deleteItem(int customerId);

}
