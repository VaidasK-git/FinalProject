package lt.vcs.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import lt.vcs.finalproject.repository.Customer;
import lt.vcs.finalproject.repository.CustomerDao;
import lt.vcs.finalproject.repository.CustomerDatabase;
import lt.vcs.finalproject.repository.Product;
import lt.vcs.finalproject.repository.ProductDao;
import lt.vcs.finalproject.repository.ProductDatabase;

public class MainActivity extends AppCompatActivity {

    List<Customer> customersList;
    List<Product> productList;
    ArrayAdapter<Customer> arrayAdapter;
    ListView elementListView;
    Button addButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomerDatabase customerDatabase =
                Room.databaseBuilder(
                        getApplicationContext(),
                        CustomerDatabase.class,
                        "customers.db"
                ).allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();


        CustomerDao customerDao = customerDatabase.customerDao();

        customersList = new ArrayList();

        customersList = customerDao.getAll();

        setUpListView();

        setUpAddButtonClick();

    }


    private void setUpListView() {
        elementListView = findViewById(R.id.customerListView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, customersList);
        elementListView.setAdapter(arrayAdapter);
    }

    private void setUpAddButtonClick() {
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, CustomerActivity.class);
                startActivity(intent);
            }
        });

    }


}