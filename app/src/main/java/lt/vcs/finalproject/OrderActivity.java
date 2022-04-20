package lt.vcs.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import lt.vcs.finalproject.repository.Customer;
import lt.vcs.finalproject.repository.CustomerDao;
import lt.vcs.finalproject.repository.FormulaDao;
import lt.vcs.finalproject.repository.MainDatabase;
import lt.vcs.finalproject.repository.OrderDao;
import lt.vcs.finalproject.repository.OrderDetails;
import lt.vcs.finalproject.repository.OrderDetailsDao;

public class OrderActivity extends AppCompatActivity {

    private Button closeButton;
    private Intent intent;
    private OrderDetails orderDetails;

    private OrderDetailsDao orderDetailsDao;

    private TextView firstAndLastNameTextView;
    private TextView oxidantsAndColorsTextView;
    private TextView timeAndPriceTextView;
    private AlertDialog.Builder builder;

    int customerId;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupUI();

        oxidantsAndColorsTextViewClick();

        setUpCloseButton();

        intent = getIntent();

        customerId = intent.getIntExtra("lt.vcs.finalproject.mainactivity.customerid", 0);

        MainDatabase mainDatabase = MainDatabase.getInstance(getApplicationContext());
        orderDetailsDao = mainDatabase.orderDetailsDao();

        orderDetails = orderDetailsDao.getItem(customerId);

        firstAndLastNameTextView.setText(
                "Customer: " + orderDetails.getCustomerFirstName() + " " + orderDetails.getCustomerLastName() + " " + orderDetails.getCustomerPhoneNumber());

        oxidantsAndColorsTextView.setText(
                "Oxidants: \n" +
                        getPlainTextFromList(orderDetails.getOxidants()) +
                        "\nColors:\n" +
                        getPlainTextFromList(orderDetails.getColors()));
        timeAndPriceTextView.setText("Time: " + orderDetails.getFormulaTime() + " min. \nPrice: " + orderDetails.getFormulaPrice() + " Eur.");

//        firstAndLastNameTextView.setText("Customer: " + orderDetails.getCustomerFirstName() + " " + orderDetails.getCustomerLastName() + " " + orderDetails.getCustomerPhoneNumber());
//        oxidantsAndColorsTextView.setText("Oxidants: " + orderDetails.getOxidants() + "\nColors: " + orderDetails.getColors());
//        timeAndPriceTextView.setText("Time: " + orderDetails.getFormulaTime() + " min.\nPrice: " + orderDetails.getFormulaPrice() + " Eur.");

    }

    private void setupUI() {
        setContentView(R.layout.activity_order);
        firstAndLastNameTextView = findViewById(R.id.firstAndLastNameTextView);
        oxidantsAndColorsTextView = findViewById(R.id.oxidantsAndColorsTextView);
        timeAndPriceTextView = findViewById(R.id.timeAndPriceTextView);
    }

    private void oxidantsAndColorsTextViewClick() {
        oxidantsAndColorsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpMessageBuilder();
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("text label", oxidantsAndColorsTextView.getText());
                clipboard.setPrimaryClip(clip);
            }
        });
    }

    private void setUpMessageBuilder() {
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Text was copied to clipboard");
        builder.setNeutralButton("Ok", null);
        builder.show();
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

    private <T> String getPlainTextFromList(List<T> list) {
        String resultText = "";
        for (T item : list) {
            resultText += item.toString() + "\n";
        }
        return resultText;
    }
}
