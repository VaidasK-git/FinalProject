package lt.vcs.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import lt.vcs.finalproject.repository.Customer;
import lt.vcs.finalproject.repository.CustomerDao;
import lt.vcs.finalproject.repository.FormulaDao;
import lt.vcs.finalproject.repository.MainDatabase;

public class OrderActivity extends AppCompatActivity {

    Button closeButton;
    Intent intent;
    TextView textView;
    Customer customer;
    CustomerDao customerDao;
    FormulaDao formulaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setUpCloseButton();

        intent = getIntent();

        int customerId = intent.getIntExtra(Constants.ENTITY_CUSTOMERS_TABLE, 0);

        connectToDatabase();

        customer = customerDao.getItem(customerId);

        textView = findViewById(R.id.orderTextView);

        textView.setText(String.valueOf(customer));

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

    private void setUpCloseButton() {
        closeButton = findViewById(R.id.closeButtonOrder);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
