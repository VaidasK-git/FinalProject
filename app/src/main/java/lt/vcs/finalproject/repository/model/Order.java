package lt.vcs.finalproject.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lt.vcs.finalproject.Constants;

@Entity(tableName = Constants.ENTITY_ORDERS_TABLE)
public class Order {

    @PrimaryKey(autoGenerate = true)
    private int orderId;

    @ColumnInfo(name = "customerId")
    private int customerId;

    @ColumnInfo(name = "formulaId")
    private int formulaId;

    public Order(int customerId, int formulaId) {
        this.customerId = customerId;
        this.formulaId = formulaId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFormulaId() {
        return formulaId;
    }

}
