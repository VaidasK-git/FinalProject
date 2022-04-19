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
import lt.vcs.finalproject.repository.OrderDao;

public class OrderActivity extends AppCompatActivity {

    private Button closeButton;
    private Intent intent;
    private TextView textView;
    private Customer customer;

    private CustomerDao customerDao;
    private FormulaDao formulaDao;
    private OrderDao orderDao;

    private TextView orderTextView;


    int customerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupUI();

        setUpCloseButton();

        intent = getIntent();

        customerId = intent.getIntExtra("lt.vcs.finalproject.mainactivity.customerid", 0);

        MainDatabase mainDatabase = MainDatabase.getInstance(getApplicationContext());
        customerDao = mainDatabase.customerDao();
        formulaDao = mainDatabase.formulaDao();
        orderDao = mainDatabase.orderDao();

        customer = customerDao.getItem(customerId);

        orderTextView.setText(String.valueOf(customer.getCustomerId()));

    }

    private void setupUI() {
        setContentView(R.layout.activity_order);
        orderTextView = findViewById(R.id.orderTextView);

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
