package lt.vcs.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import lt.vcs.finalproject.repository.Customer;
import lt.vcs.finalproject.repository.CustomerDao;
import lt.vcs.finalproject.repository.MainDatabase;

public class MainActivity extends AppCompatActivity {

    List<Customer> customersList;
    ArrayAdapter arrayAdapter;

    ListView elementListView;
    Button addButton;

    Customer clickedCustomer;
    Intent intent;
    AlertDialog.Builder builder;

    CustomerDao customerDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpUi();

        MainDatabase mainDatabase = MainDatabase.getInstance(getApplicationContext());
        customerDao = mainDatabase.customerDao();

        customersList = new ArrayList();
        customersList = customerDao.getAll();

        setUpListView();
        setUpListViewItemClick();
        setUpListViewItemLongClick();

        setUpAddButtonClick();

        intent = getIntent();

    }

    public void setUpUi() {
        setContentView(R.layout.activity_main);
        elementListView = findViewById(R.id.customerListView);
        addButton = findViewById(R.id.addButton);
    }

    private void setUpListView() {
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, customersList);
        elementListView.setAdapter(arrayAdapter);
    }

    private void setUpListViewItemClick() {
        elementListView.setOnItemClickListener((adapterView, view, position, l) -> {
            intent = new Intent(MainActivity.this, OrderActivity.class);
            clickedCustomer = customersList.get(position);
            intent.putExtra("lt.vcs.finalProject.mainActivity.customerId", clickedCustomer.getCustomerId());
            startActivity(intent);
        });
    }

    private void setUpDialogBuilder(int position) {
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you would like to delete customer?");
        builder.setPositiveButton("Yes", (dialogInterface, i) -> {

            customerDao.deleteItem(clickedCustomer.getCustomerId());

            customersList.remove(position);
            arrayAdapter.notifyDataSetChanged();
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    private void setUpListViewItemLongClick() {
        elementListView.setOnItemLongClickListener((adapterView, view, position, id) -> {
            setUpDialogBuilder(position);
            clickedCustomer = customersList.get(position);
            return true;
        });
    }

    private void setUpAddButtonClick() {
        addButton.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, CustomerActivity.class);
            startActivity(intent);
        });

    }

}