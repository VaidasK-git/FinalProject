package lt.vcs.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import lt.vcs.finalproject.repository.Customer;
import lt.vcs.finalproject.repository.CustomerDao;
import lt.vcs.finalproject.repository.FormulaDao;
import lt.vcs.finalproject.repository.MainDatabase;

public class CustomerActivity extends AppCompatActivity {

    Button backButtonCustomer;
    Intent intent;
    CustomerDao customerDao;
    FormulaDao formulaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        connectToDatabase();


        setUpBackButtonClickCustomer();
        setUpNextButtonClickCustomer();

        intent = getIntent();
    }

    private void connectToDatabase() {
        MainDatabase mainDatabase =
                Room.databaseBuilder(
                        getApplicationContext(),
                        MainDatabase.class,
                        "main.db"
                ).allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();

        customerDao = mainDatabase.customerDao();
        formulaDao = mainDatabase.formulaDao();
    }

    private void setUpBackButtonClickCustomer() {
        backButtonCustomer = findViewById(R.id.customerBackButton);
        backButtonCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setUpNextButtonClickCustomer() {
        backButtonCustomer = findViewById(R.id.customerNextButton);

        final EditText editTextCustomerFirstName = findViewById(R.id.customerFirstName);
        final EditText editTextCustomerLastName = findViewById(R.id.customerLastName);
        final EditText editTextCustomerPhoneNumber = findViewById(R.id.customerPhoneNumber);

        backButtonCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customerFirstName = editTextCustomerFirstName.getText().toString();
                String customerLastName = editTextCustomerLastName.getText().toString();
                String customerPhoneNumber = editTextCustomerPhoneNumber.getText().toString();

                Customer customer = new Customer(customerFirstName, customerLastName, customerPhoneNumber);

//                customerDao.insertCustomer(customer);

                intent = new Intent(CustomerActivity.this, FormulaActivity.class);

                startActivity(intent);
            }
        });
    }
}