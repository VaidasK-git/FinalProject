package lt.vcs.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import lt.vcs.finalproject.repository.Customer;
import lt.vcs.finalproject.repository.CustomerDao;
import lt.vcs.finalproject.repository.MainDatabase;

public class CustomerActivity extends AppCompatActivity {

    EditText editTextCustomerFirstName;
    EditText editTextCustomerLastName;
    EditText editTextCustomerPhoneNumber;
    Button backButtonCustomer;
    Button nextButtonCustomer;

    Intent intent;
    CustomerDao customerDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpUi();

        MainDatabase mainDatabase = MainDatabase.getInstance(getApplicationContext());
        customerDao = mainDatabase.customerDao();

        setUpBackButtonClickCustomer();
        setUpNextButtonClickCustomer();

        intent = getIntent();
    }

    private void setUpUi() {

        setContentView(R.layout.activity_customer);
        editTextCustomerFirstName = findViewById(R.id.customerFirstName);
        editTextCustomerLastName = findViewById(R.id.customerLastName);
        editTextCustomerPhoneNumber = findViewById(R.id.customerPhoneNumber);
        backButtonCustomer = findViewById(R.id.customerBackButton);
        nextButtonCustomer = findViewById(R.id.customerNextButton);

    }

    private void setUpBackButtonClickCustomer() {
        backButtonCustomer.setOnClickListener(view -> finish());
    }

    private void setUpNextButtonClickCustomer() {

        nextButtonCustomer.setOnClickListener(view -> {

            String customerFirstName = editTextCustomerFirstName.getText().toString();
            String customerLastName = editTextCustomerLastName.getText().toString();
            String customerPhoneNumber = editTextCustomerPhoneNumber.getText().toString();

            Customer customer = new Customer(customerFirstName, customerLastName, customerPhoneNumber);

            if (!customerFirstName.isEmpty()) {

                if(!customerLastName.isEmpty()) {

                    if (!customerPhoneNumber.isEmpty()) {

                        customerDao.insertCustomer(customer);

                        intent = new Intent(CustomerActivity.this, FormulaActivity.class);

                        startActivity(intent);

                    } else {
                        editTextCustomerPhoneNumber.setError("First name is required!");
                    }

                } else {
                    editTextCustomerLastName.setError("Last mane is required!");
                }

            } else {
                editTextCustomerFirstName.setError("Phone number is required!");
            }

        });

    }

}

