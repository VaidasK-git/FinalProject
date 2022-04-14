package lt.vcs.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import lt.vcs.finalproject.repository.Color;
import lt.vcs.finalproject.repository.Customer;
import lt.vcs.finalproject.repository.CustomerDao;
import lt.vcs.finalproject.repository.Formula;
import lt.vcs.finalproject.repository.FormulaDao;
import lt.vcs.finalproject.repository.MainDatabase;
import lt.vcs.finalproject.repository.Oxidant;

public class FormulaActivity extends AppCompatActivity {

    Button saveButtonFormula;
    Intent intent;
    CustomerDao customerDao;
    FormulaDao formulaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);

        connectToDatabase();

        setUpSpinners();

        setUpSaveButtonClickFormula();

        intent = getIntent();

        onBackPressed();
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

    private void setUpSpinners() {
        setUpColorSpinner(R.id.spinnerColorManufacturerOne, R.id.spinnerColorProductOne);
        setUpColorSpinner(R.id.spinnerColorManufacturerTwo, R.id.spinnerColorProductTwo);
        setUpColorSpinner(R.id.spinnerColorManufacturerThree, R.id.spinnerColorProductThree);
        setUpColorSpinner(R.id.spinnerColorManufacturerFour, R.id.spinnerColorProductFour);
    }

    private void setUpColorSpinner(int manufacturerId, int productId) {

        Spinner manufacturerSpinner = findViewById(manufacturerId);
        Spinner productSpinner = findViewById(productId);

        manufacturerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass) {
                    case "":
                        productSpinner.setAdapter(new ArrayAdapter<String>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_empty_products_array)));
                        break;

                    case "INOA":
                        productSpinner.setAdapter(new ArrayAdapter<String>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_products_array)));
                        break;

                    case "INOA Bronzing":
                        productSpinner.setAdapter(new ArrayAdapter<String>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_bronzing_products_array)));
                        break;

                    case "INOA Carmilane":
                        productSpinner.setAdapter(new ArrayAdapter<String>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_carmilane_products_array)));
                        break;

                    case "INOA Fundamental":
                        productSpinner.setAdapter(new ArrayAdapter<String>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_fundamentals_products_array)));
                        break;

                    case "INOA Glow":
                        productSpinner.setAdapter(new ArrayAdapter<String>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_glow_products_array)));
                        break;

                    case "INOA High Resist":
                        productSpinner.setAdapter(new ArrayAdapter<String>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_hresist_products_array)));
                        break;

                    case "INOA Marron Resist":
                        productSpinner.setAdapter(new ArrayAdapter<String>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_mresist_products_array)));
                        break;

                    case "INOA Rubilane":
                        productSpinner.setAdapter(new ArrayAdapter<String>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_rubilane_products_array)));
                        break;
                    case "INOA Supreme":
                        productSpinner.setAdapter(new ArrayAdapter<String>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_supreme_products_array)));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setUpSaveButtonClickFormula() {
        saveButtonFormula = findViewById(R.id.formulaSaveButton);


        saveButtonFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Oxidant oxidantOne = new Oxidant("INOA Oxidant", "3%", 6);
                Oxidant oxidantTwo = new Oxidant("INOA Oxidant", "6%", 12);
                Color colorOne = new Color("INOA", "6", 15);
                Color colorTwo = new Color("INOA", "6.5", 28);
                Formula formula = new Formula(45, 85);
                formula.add(oxidantOne);
                formula.add(oxidantTwo);
                formula.add(colorOne);
                formula.add(colorTwo);

//                formulaDao.insertFormula(formula);

                intent = new Intent(FormulaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}