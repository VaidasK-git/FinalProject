package lt.vcs.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class FormulaActivity extends AppCompatActivity {

    Button backButtonFormula;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);

//        setupSpinners();

        setUpBackButtonClickFormula();
        setUpSaveButtonClickFormula();

        intent = getIntent();

    }

    private void setUpBackButtonClickFormula() {
        backButtonFormula = findViewById(R.id.formulaBackButton);
        backButtonFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setUpSaveButtonClickFormula() {
        backButtonFormula = findViewById(R.id.formulaSaveButton);
        backButtonFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void setupSpinners(){
        setupOxidantSpinners();
    }

    public void setupOxidantSpinners(){
        setupSpinnerOxidantManufacturerOne();
        setupSpinnerOxidantManufacturerTwo();
        setupSpinnerOxidantProductOne();
        setupSpinnerOxidantProductTwo();
    }

    private void setupSpinnerOxidantManufacturerOne() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerOxidantManufacturerOne);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.oxidants_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setupSpinnerOxidantManufacturerTwo() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerOxidantManufacturerOne);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.oxidants_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setupSpinnerOxidantProductOne() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerOxidantProductOne);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.oxidants_product_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setupSpinnerOxidantProductTwo() {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerOxidantProductOne);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.oxidants_product_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}