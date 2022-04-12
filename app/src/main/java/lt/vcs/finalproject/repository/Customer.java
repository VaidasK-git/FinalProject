package lt.vcs.finalproject.repository;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lt.vcs.finalproject.Constants;

@Entity(tableName = Constants.ENTITY_CUSTOMERS_TABLE)
public class Customer {

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

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    @Override
    public String toString() {
        return customerId + " " +customerFirstName + " " + customerLastName;
    }


}
