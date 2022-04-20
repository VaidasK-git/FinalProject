package lt.vcs.finalproject.repository.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lt.vcs.finalproject.Constants;

@Entity(tableName = Constants.ENTITY_CUSTOMERS_TABLE)
public class Customer implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int customerId;

    @ColumnInfo(name = "customerFirstName")
    private String customerFirstName;

    @ColumnInfo (name = "customerLastName")
    private String customerLastName;

    @ColumnInfo (name = "customerPhoneNumber")
    private String customerPhoneNumber;



    public Customer(String customerFirstName, String customerLastName, String customerPhoneNumber) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    @NonNull
    @Override
    public String toString() {
        return customerFirstName + " " + customerLastName;
    }

}
