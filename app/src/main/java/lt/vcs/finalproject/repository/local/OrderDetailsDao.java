package lt.vcs.finalproject.repository.local;

import androidx.room.Dao;
import androidx.room.Query;

import lt.vcs.finalproject.Constants;
import lt.vcs.finalproject.repository.model.OrderDetails;

@Dao
public interface OrderDetailsDao {

    @Query("SELECT * FROM " + Constants.ENTITY_ORDER_DETAILS_TABLE + " WHERE customerId =:orderId")
    OrderDetails getItem(int orderId);


}
