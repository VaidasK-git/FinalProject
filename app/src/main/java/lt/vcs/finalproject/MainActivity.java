package lt.vcs.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import lt.vcs.finalproject.repository.Customer;
import lt.vcs.finalproject.repository.CustomerDao;
import lt.vcs.finalproject.repository.FormulaDao;
import lt.vcs.finalproject.repository.MainDatabase;
import lt.vcs.finalproject.repository.Product;
import lt.vcs.finalproject.repository.ProductDao;

public class MainActivity extends AppCompatActivity {

    List<Customer> customersList;
    ArrayAdapter<Customer> arrayAdapter;
    ListView elementListView;
    CustomerDao customerDao;
    FormulaDao formulaDao;
    Customer clickedCustomer;
    Button addButton;
    Intent intent;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectToDatabase();

        customersList = new ArrayList();

        customersList = customerDao.getAll();

        setUpListView();
        setUpListViewItemClick();
        setUpListViewItemLongClick();

        setUpAddButtonClick();

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

    private void setUpListView() {
        elementListView = findViewById(R.id.customerListView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, customersList);
        elementListView.setAdapter(arrayAdapter);
    }

    private void setUpListViewItemClick() {
        elementListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                intent = new Intent(MainActivity.this, OrderActivity.class);
                clickedCustomer = customersList.get(position);
                intent.putExtra("Message", clickedCustomer.getCustomerId());
                startActivity(intent);
            }
        });
    }

    private void setUpDialogBuilder(int position) {
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you would like to delete customer?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                customersList.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    private void setUpListViewItemLongClick() {
        elementListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(
                    AdapterView<?> adapterView,
                    View view,
                    int position,
                    long id) {
                customerDao.deleteItem(position);
                setUpDialogBuilder(position);
                return true;
            }
        });
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