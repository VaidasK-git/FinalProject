package lt.vcs.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import lt.vcs.finalproject.repository.model.Customer;
import lt.vcs.finalproject.repository.local.CustomerDao;
import lt.vcs.finalproject.repository.local.FormulaDao;
import lt.vcs.finalproject.repository.local.MainDatabase;

public class MainActivity extends AppCompatActivity {

    List<Customer> customersList;
    ArrayAdapter arrayAdapter;

    ListView elementListView;
    Button addButton;

    Customer clickedCustomer;
    Intent intent;
    AlertDialog.Builder builder;

    CustomerDao customerDao;
    FormulaDao formulaDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainDatabase mainDatabase = MainDatabase.getInstance(getApplicationContext());
        customerDao = mainDatabase.customerDao();
        formulaDao = mainDatabase.formulaDao();

        customersList = new ArrayList();
        customersList = customerDao.getAll();

        setUpListView();
        setUpListViewItemClick();
        setUpListViewItemLongClick();

        setUpAddButtonClick();

        intent = getIntent();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_bar, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.searchBar).getActionView();

        searchView.getQueryHint();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void setUpListView() {
        elementListView = findViewById(R.id.customerListView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, customersList);
        elementListView.setAdapter(arrayAdapter);
    }

    private void setUpListViewItemClick() {
        elementListView.setOnItemClickListener((adapterView, view, position, l) -> {
            intent = new Intent(MainActivity.this, OrderActivity.class);
            clickedCustomer = customersList.get(position);
            intent.putExtra("lt.vcs.finalproject.mainactivity.customerid", clickedCustomer.getCustomerId());
            startActivity(intent);
        });
    }

    private void setUpDialogBuilder(int position) {
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you would like to delete customer?");
        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
            customersList.remove(position);
            customerDao.deleteItem(position);
            formulaDao.deleteItem(position);
            arrayAdapter.notifyDataSetChanged();
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    private void setUpListViewItemLongClick() {
        elementListView.setOnItemLongClickListener((adapterView, view, position, id) -> {
            setUpDialogBuilder(position);
            return true;
        });
    }

    private void setUpAddButtonClick() {
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, CustomerActivity.class);
            startActivity(intent);
        });

    }

}