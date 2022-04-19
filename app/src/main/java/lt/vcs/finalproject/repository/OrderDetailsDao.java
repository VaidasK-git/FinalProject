package lt.vcs.finalproject.repository;

import androidx.room.Dao;
import androidx.room.Query;

import lt.vcs.finalproject.Constants;

@Dao
public interface OrderDetailsDao {

    @Query("SELECT * FROM " + Constants.ENTITY_ORDER_DETAILS_TABLE + " WHERE customerId =:orderId")
    OrderDetails getItem(int orderId);


}
