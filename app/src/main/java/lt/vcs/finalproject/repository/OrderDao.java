package lt.vcs.finalproject.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import lt.vcs.finalproject.Constants;

@Dao
public interface OrderDao {

    @Query("SELECT * FROM " + Constants.ENTITY_ORDERS_TABLE)
    List<Order> getAll();

    @Query("SELECT * FROM " + Constants.ENTITY_ORDERS_TABLE + " WHERE orderId =:orderId")
    Order getItem(int orderId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrders(List<Order> orders);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrder(Order order);

    @Delete
    void deleteOrders(List<Order> orders);

    @Delete
    void deleteOrder(Order order);

    @Query("DELETE FROM " + Constants.ENTITY_ORDERS_TABLE + " WHERE orderId =:orderId")
    void deleteItem(int orderId);
}
