package lt.vcs.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import lt.vcs.finalproject.repository.MainDatabase;
import lt.vcs.finalproject.repository.OrderDetails;
import lt.vcs.finalproject.repository.OrderDetailsDao;

public class OrderActivity extends AppCompatActivity {

    TextView firstAndLastNameTextView;
    TextView oxidantsAndColorsTextView;
    TextView timeAndPriceTextView;
    Button closeButton;

    AlertDialog.Builder builder;

    Intent intent;
    OrderDetails orderDetails;
    OrderDetailsDao orderDetailsDao;

    int customerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupUI();

        intent = getIntent();

        customerId = intent.getIntExtra("lt.vcs.finalProject.mainActivity.customerId", 0);

        MainDatabase mainDatabase = MainDatabase.getInstance(getApplicationContext());
        orderDetailsDao = mainDatabase.orderDetailsDao();

        orderDetails = orderDetailsDao.getItem(customerId);

        setupView();

        oxidantsAndColorsTextViewClick();

        setUpCloseButton();

    }

    private void setupUI() {
        setContentView(R.layout.activity_order);
        firstAndLastNameTextView = findViewById(R.id.firstAndLastNameTextView);
        oxidantsAndColorsTextView = findViewById(R.id.oxidantsAndColorsTextView);
        timeAndPriceTextView = findViewById(R.id.timeAndPriceTextView);
    }

    @SuppressLint("SetTextI18n")
    private void setupView() {
        firstAndLastNameTextView.setText(
                "Customer: " + orderDetails.getCustomerFirstName() + " "
                        + orderDetails.getCustomerLastName()
                        + "\nPhone: " + orderDetails.getCustomerPhoneNumber());

        oxidantsAndColorsTextView.setText(
                "Oxidants: \n" +
                        getPlainTextFromList(orderDetails.getOxidants()) +
                        "\nColors:\n" +
                        getPlainTextFromList(orderDetails.getColors()));
        timeAndPriceTextView.setText("Time: " + orderDetails.getFormulaTime() + " min. \nPrice: "
                + orderDetails.getFormulaPrice() + " Eur.");
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
            resultText = resultText.concat(item.toString() + "\n");
        }
        return resultText;
    }
}
