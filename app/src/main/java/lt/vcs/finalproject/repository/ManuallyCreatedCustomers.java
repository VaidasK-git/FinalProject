package lt.vcs.finalproject.repository;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import lt.vcs.finalproject.repository.Customer;

public class ManuallyCreatedCustomers {

    public static List<Customer> getCustomers() {

        List<Customer> customersList = new ArrayList();

        Resources resources = Resources.getSystem();

        Customer customer1 = new Customer("Jonas", "Jonaitis", "+37061523984");
        customersList.add(customer1);

        Customer customer2 = new Customer("Petras", "Petraitis", "+37061458967");
        customersList.add(customer2);

        Customer customer3 = new Customer("Antanas", "Antanaitis", "+37062897458");
        customersList.add(customer3);

        return customersList;
    }


}
