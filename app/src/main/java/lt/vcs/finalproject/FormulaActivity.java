package lt.vcs.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import lt.vcs.finalproject.repository.Color;
import lt.vcs.finalproject.repository.CustomerDao;
import lt.vcs.finalproject.repository.Formula;
import lt.vcs.finalproject.repository.FormulaDao;
import lt.vcs.finalproject.repository.MainDatabase;
import lt.vcs.finalproject.repository.Order;
import lt.vcs.finalproject.repository.OrderDao;
import lt.vcs.finalproject.repository.Oxidant;

public class FormulaActivity extends AppCompatActivity {

    Spinner spinnerOxidantManufacturerOne;
    Spinner spinnerOxidantProductOne;
    EditText editTextOxidantWeightOne;
    Spinner spinnerOxidantManufacturerTwo;
    Spinner spinnerOxidantProductTwo;
    EditText editTextOxidantWeightTwo;
    Spinner spinnerColorManufacturerOne;
    Spinner spinnerColorProductOne;
    EditText editTextColorWeightOne;
    Spinner spinnerColorManufacturerTwo;
    Spinner spinnerColorProductTwo;
    EditText editTextColorWeightTwo;
    Spinner spinnerColorManufacturerThree;
    Spinner spinnerColorProductThree;
    EditText editTextColorWeightThree;
    Spinner spinnerColorManufacturerFour;
    Spinner spinnerColorProductFour;
    EditText editTextColorWeightFour;
    EditText editTextFormulaTime;
    EditText editTextFormulaPrice;
    Button saveButtonFormula;

    Intent intent;
    CustomerDao customerDao;
    FormulaDao formulaDao;
    OrderDao orderDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpUi();

        MainDatabase mainDatabase = MainDatabase.getInstance(getApplicationContext());
        customerDao = mainDatabase.customerDao();
        formulaDao = mainDatabase.formulaDao();
        orderDao = mainDatabase.orderDao();

        setUpSpinners();

        setUpSaveButtonClickFormula();

        onBackPressed();

        intent = getIntent();

    }

    private void setUpUi(){

        setContentView(R.layout.activity_formula);
        spinnerOxidantManufacturerOne = findViewById(R.id.spinnerOxidantManufacturerOne);
        spinnerOxidantProductOne = findViewById(R.id.spinnerOxidantProductOne);
        editTextOxidantWeightOne = findViewById(R.id.oxidantWeightOne);
        spinnerOxidantManufacturerTwo = findViewById(R.id.spinnerOxidantManufacturerTwo);
        spinnerOxidantProductTwo = findViewById(R.id.spinnerOxidantProductTwo);
        editTextOxidantWeightTwo = findViewById(R.id.oxidantWeightTwo);
        spinnerColorManufacturerOne = findViewById(R.id.spinnerColorManufacturerOne);
        spinnerColorProductOne = findViewById(R.id.spinnerColorProductOne);
        editTextColorWeightOne = findViewById(R.id.colorWeightOne);
        spinnerColorManufacturerTwo = findViewById(R.id.spinnerColorManufacturerTwo);
        spinnerColorProductTwo = findViewById(R.id.spinnerColorProductTwo);
        editTextColorWeightTwo = findViewById(R.id.colorWeightTwo);
        spinnerColorManufacturerThree = findViewById(R.id.spinnerColorManufacturerThree);
        spinnerColorProductThree = findViewById(R.id.spinnerColorProductThree);
        editTextColorWeightThree = findViewById(R.id.colorWeightThree);
        spinnerColorManufacturerFour = findViewById(R.id.spinnerColorManufacturerFour);
        spinnerColorProductFour = findViewById(R.id.spinnerColorProductFour);
        editTextColorWeightFour = findViewById(R.id.colorWeightFour);
        editTextFormulaTime = findViewById(R.id.formulaTime);
        editTextFormulaPrice = findViewById(R.id.formulaPrice);
        saveButtonFormula = findViewById(R.id.formulaSaveButton);

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

        saveButtonFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oxidantManufacturerOne = spinnerOxidantManufacturerOne.getSelectedItem().toString();
                String oxidantProductOne = spinnerOxidantProductOne.getSelectedItem().toString();
                int oxidantWeightOne;
                if (editTextOxidantWeightOne.getText().toString().equals("")) {
                    oxidantWeightOne = 0;
                } else {
                    oxidantWeightOne = Integer.parseInt(editTextOxidantWeightOne.getText().toString());
                }
                Oxidant oxidantOne = new Oxidant(oxidantManufacturerOne, oxidantProductOne, oxidantWeightOne);

                String oxidantManufacturerTwo = spinnerOxidantManufacturerTwo.getSelectedItem().toString();
                String oxidantProductTwo = spinnerOxidantProductTwo.getSelectedItem().toString();
                int oxidantWeightTwo;
                if (editTextOxidantWeightTwo.getText().toString().equals("")) {
                    oxidantWeightTwo = 0;
                } else {
                    oxidantWeightTwo = Integer.parseInt(editTextOxidantWeightTwo.getText().toString());
                }
                Oxidant oxidantTwo = new Oxidant(oxidantManufacturerTwo, oxidantProductTwo, oxidantWeightTwo);

                String colorManufacturerOne = spinnerColorManufacturerOne.getSelectedItem().toString();
                String colorProductOne = spinnerColorProductOne.getSelectedItem().toString();
                int colorWeightOne;
                if (editTextColorWeightOne.getText().toString().equals("")) {
                    colorWeightOne = 0;
                } else {
                    colorWeightOne = Integer.parseInt(editTextColorWeightOne.getText().toString());
                }
                Color colorOne = new Color(colorManufacturerOne, colorProductOne, colorWeightOne);

                String colorManufacturerTwo = spinnerColorManufacturerTwo.getSelectedItem().toString();
                ;
                String colorProductTwo = spinnerColorProductTwo.getSelectedItem().toString();
                int colorWeightTwo;
                if (editTextColorWeightTwo.getText().toString().equals("")) {
                    colorWeightTwo = 0;
                } else {
                    colorWeightTwo = Integer.parseInt(editTextColorWeightTwo.getText().toString());
                }
                Color colorTwo = new Color(colorManufacturerTwo, colorProductTwo, colorWeightTwo);

                String colorManufacturerThree = spinnerColorManufacturerThree.getSelectedItem().toString();
                ;
                String colorProductThree = spinnerColorProductThree.getSelectedItem().toString();
                int colorWeightThree;
                if (editTextColorWeightThree.getText().toString().equals("")) {
                    colorWeightThree = 0;
                } else {
                    colorWeightThree = Integer.parseInt(editTextColorWeightThree.getText().toString());
                }
                Color colorThree = new Color(colorManufacturerThree, colorProductThree, colorWeightThree);

                String colorManufacturerFour = spinnerColorManufacturerFour.getSelectedItem().toString();
                ;
                String colorProductFour = spinnerColorProductFour.getSelectedItem().toString();
                int colorWeightFour;
                if (editTextColorWeightFour.getText().toString().equals("")) {
                    colorWeightFour = 0;
                } else {
                    colorWeightFour = Integer.parseInt(editTextColorWeightFour.getText().toString());
                }
                Color colorFour = new Color(colorManufacturerFour, colorProductFour, colorWeightFour);

                int formulaTime;
                if (editTextFormulaTime.getText().toString().equals("")) {
                    formulaTime = 0;
                } else {
                    formulaTime = Integer.parseInt(editTextFormulaTime.getText().toString());
                }

                int formulaPrice;
                if (editTextFormulaPrice.getText().toString().equals("")) {
                    formulaPrice = 0;
                } else {
                    formulaPrice = Integer.parseInt(editTextFormulaPrice.getText().toString());
                }

                Formula formula = new Formula(formulaTime, formulaPrice);

                if (!oxidantManufacturerOne.equals("")) {
                    formula.add(oxidantOne);
                }
                if (!oxidantManufacturerTwo.equals("")) {
                    formula.add(oxidantTwo);
                }
                if (!colorManufacturerOne.equals("")) {
                    formula.add(colorOne);
                }
                if (!colorManufacturerTwo.equals("")) {
                    formula.add(colorTwo);
                }
                if (!colorManufacturerThree.equals("")) {
                    formula.add(colorThree);
                }
                if (!colorManufacturerFour.equals("")) {
                    formula.add(colorFour);
                }

                formulaDao.insertFormula(formula);

                int customerId = customerDao.getMaxCustomerId();
                int formulaId = formulaDao.getMaxFormulaId();
                Order order = new Order(customerId, formulaId);

                orderDao.insertOrder(order);

                intent = new Intent(FormulaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}