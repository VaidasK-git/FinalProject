package lt.vcs.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import lt.vcs.finalproject.repository.local.FormulaDao;
import lt.vcs.finalproject.repository.local.MainDatabase;
import lt.vcs.finalproject.repository.local.OrderDao;
import lt.vcs.finalproject.repository.local.OrderDetailsDao;
import lt.vcs.finalproject.repository.model.OrderDetails;

public class OrderActivity extends AppCompatActivity {

    private Button closeButton;
    private Intent intent;
    private OrderDetails orderDetails;

    private OrderDetailsDao orderDetailsDao;

    private TextView firstAndLastNameTextView;
    private TextView oxidantsAndColorsTextView;
    private TextView timeAndPriceTextView;
    private AlertDialog.Builder builder;

    private int customerId;

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
                "First Name: " + orderDetails.getCustomerFirstName() + " \n" +
                        "Last Name: " + orderDetails.getCustomerLastName() + " \n" +
                        "Phone: " + orderDetails.getCustomerPhoneNumber());

        oxidantsAndColorsTextView.setText(
                "Oxidants: \n" +
                        getPlainTextFromList(orderDetails.getOxidants()) +
                        "\nColors:\n" +
                        getPlainTextFromList(orderDetails.getColors()));
        timeAndPriceTextView.setText("Time: " + orderDetails.getFormulaTime() + "\nPrice: " + orderDetails.getFormulaPrice());

    }

    private void setupUI() {
        setContentView(R.layout.activity_order);
        firstAndLastNameTextView = findViewById(R.id.firstAndLastNameTextView);
        oxidantsAndColorsTextView = findViewById(R.id.oxidantsAndColorsTextView);
        timeAndPriceTextView = findViewById(R.id.timeAndPriceTextView);
    }

    private void oxidantsAndColorsTextViewClick() {
        oxidantsAndColorsTextView.setOnClickListener(view -> {
            setUpMessageBuilder();
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("text label", oxidantsAndColorsTextView.getText());
            clipboard.setPrimaryClip(clip);
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
        closeButton.setOnClickListener(view -> finish());
    }

    private <T> String getPlainTextFromList(List<T> list) {
        String resultText = "";
        for (T item : list) {
            resultText += item.toString() + "\n";
        }
        return resultText;
    }
}
