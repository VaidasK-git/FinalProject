package lt.vcs.finalproject.repository.model;

import androidx.room.DatabaseView;

@DatabaseView("SELECT customers.customerId, customers.customerFirstName, customers.customerLastName, customers.customerPhoneNumber, formulas.oxidants, formulas.colors, formulas.formulaTime, formulas.formulaPrice\n" +
        "FROM customers\n" +
        "JOIN orders ON orders.customerId = customers.customerId\n" +
        "JOIN formulas ON formulas.formulaId = orders.formulaId")
public class OrderDetails {
    public int customerId;
    public String customerFirstName;
    public String customerLastName;
    public String customerPhoneNumber;
    public String oxidants;
    public String colors;
    public int formulaTime;
    public int formulaPrice;

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

    public String getOxidants() {
        return oxidants;
    }

    public String getColors() {
        return colors;
    }

    public int getFormulaTime() {
        return formulaTime;
    }

    public int getFormulaPrice() {
        return formulaPrice;
    }

}
