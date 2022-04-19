package lt.vcs.finalproject.repository;

import androidx.room.DatabaseView;

@DatabaseView("SELECT customers.customerFirstName, customers.customerLastName, formulas.oxidants, formulas.colors, formulas.formulaTime, formulas.formulaPrice\n" +
        "FROM customers\n" +
        "JOIN orders ON orders.customerId = customers.customerId\n" +
        "JOIN formulas ON formulas.formulaId = orders.formulaId;")
public class OrderDetails {

    public String customerFirstName;
    public String customerLastName;
    public String customerPhoneNumber;
    public String oxidants;
    public String colors;
    public int formulaTime;
    public int formulaPrice;

}
