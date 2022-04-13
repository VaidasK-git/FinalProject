package lt.vcs.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import lt.vcs.finalproject.repository.Customer;
import lt.vcs.finalproject.repository.CustomerDao;
import lt.vcs.finalproject.repository.CustomerDatabase;

public class FormulaActivity extends AppCompatActivity {

    Button backButtonFormula;
    Intent intent;
    CustomerDao customerDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);

        CustomerDatabase customerDatabase =
                Room.databaseBuilder(
                        getApplicationContext(),
                        CustomerDatabase.class,
                        "customers.db"
                ).allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();

        customerDao = customerDatabase.customerDao();

//        setupSpinners();

        setUpBackButtonClickFormula();
        setUpSaveButtonClickFormula();

        intent = getIntent();

    }

    private void setUpBackButtonClickFormula() {
        backButtonFormula = findViewById(R.id.formulaBackButton);
        backButtonFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setUpSaveButtonClickFormula() {
        backButtonFormula = findViewById(R.id.formulaSaveButton);

//        final EditText editTextCustomerFirstName = (EditText)findViewById(R.id.customerFirstName);
//        final EditText editTextCustomerLastName = (EditText)findViewById(R.id.customerLastName);
//        final EditText editTextCustomerPhoneNumber = (EditText)findViewById(R.id.customerPhoneNumber);

        backButtonFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String customerFirstName = editTextCustomerFirstName.getText().toString();
//                String customerLastName = editTextCustomerLastName.getText().toString();
//                String customerPhoneNumber = editTextCustomerPhoneNumber.getText().toString();
//
//                Customer customer = new Customer(customerFirstName, customerLastName, customerPhoneNumber);
//
//                customerDao.insertCustomer(customer);
            }
        });
    }

    public void setupSpinners(){
        setupOxidantSpinners();
    }

    public void setupOxidantSpinners(){
        setupSpinnerOxidantManufacturerOne();
        setupSpinnerOxidantManufacturerTwo();
        setupSpinnerOxidantProductOne();
        setupSpinnerOxidantProductTwo();
    }

    private void setupSpinnerOxidantManufacturerOne() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerOxidantManufacturerOne);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.oxidants_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setupSpinnerOxidantManufacturerTwo() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerOxidantManufacturerOne);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.oxidants_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setupSpinnerOxidantProductOne() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerOxidantProductOne);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.oxidants_product_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setupSpinnerOxidantProductTwo() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerOxidantProductOne);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.oxidants_product_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}