package lt.vcs.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerActivity extends AppCompatActivity {

    Button backButtonCustomer;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        setUpBackButtonClickCustomer();
        setUpNextButtonClickCustomer();

        intent = getIntent();
    }

    private void setUpBackButtonClickCustomer() {
        backButtonCustomer = findViewById(R.id.customerBackButton);
        backButtonCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setUpNextButtonClickCustomer() {
        backButtonCustomer = findViewById(R.id.customerNextButton);
        backButtonCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(CustomerActivity.this, FormulaActivity.class);
                startActivity(intent);
            }
        });
    }
}