package lt.vcs.finalproject;

import androidx.appcompat.app.AppCompatActivity;

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

    Formula formula;
    Oxidant oxidant;
    Color color;
    Order order;

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

    private void setUpUi() {

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
                        productSpinner.setAdapter(new ArrayAdapter<>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_empty_products_array)));
                        break;

                    case "INOA":
                        productSpinner.setAdapter(new ArrayAdapter<>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_products_array)));
                        break;

                    case "INOA Bronzing":
                        productSpinner.setAdapter(new ArrayAdapter<>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_bronzing_products_array)));
                        break;

                    case "INOA Carmilane":
                        productSpinner.setAdapter(new ArrayAdapter<>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_carmilane_products_array)));
                        break;

                    case "INOA Fundamental":
                        productSpinner.setAdapter(new ArrayAdapter<>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_fundamentals_products_array)));
                        break;

                    case "INOA Glow":
                        productSpinner.setAdapter(new ArrayAdapter<>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_glow_products_array)));
                        break;

                    case "INOA High Resist":
                        productSpinner.setAdapter(new ArrayAdapter<>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_hresist_products_array)));
                        break;

                    case "INOA Marron Resist":
                        productSpinner.setAdapter(new ArrayAdapter<>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_mresist_products_array)));
                        break;

                    case "INOA Rubilane":
                        productSpinner.setAdapter(new ArrayAdapter<>(FormulaActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.color_inoa_rubilane_products_array)));
                        break;
                    case "INOA Supreme":
                        productSpinner.setAdapter(new ArrayAdapter<>(FormulaActivity.this,
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

        saveButtonFormula.setOnClickListener(view -> {
            createFormula();

            addOxidantToFormula(spinnerOxidantManufacturerOne, spinnerOxidantProductOne, editTextOxidantWeightOne);
            addOxidantToFormula(spinnerOxidantManufacturerTwo, spinnerOxidantProductTwo, editTextOxidantWeightTwo);

            addColorToFormula(spinnerColorManufacturerOne, spinnerColorProductOne, editTextColorWeightOne);
            addColorToFormula(spinnerColorManufacturerTwo, spinnerColorProductTwo, editTextColorWeightTwo);
            addColorToFormula(spinnerColorManufacturerThree, spinnerColorProductThree, editTextColorWeightThree);
            addColorToFormula(spinnerColorManufacturerFour, spinnerColorProductFour, editTextColorWeightFour);

            if (spinnerOxidantManufacturerOne.getSelectedItem().toString().isEmpty()
                    || (!spinnerOxidantManufacturerOne.getSelectedItem().toString().isEmpty() && !editTextOxidantWeightOne.getText().toString().isEmpty())) {
                if (spinnerOxidantManufacturerTwo.getSelectedItem().toString().isEmpty()
                        || (!spinnerOxidantManufacturerTwo.getSelectedItem().toString().isEmpty() && !editTextOxidantWeightTwo.getText().toString().isEmpty())) {
                    if (spinnerColorManufacturerOne.getSelectedItem().toString().isEmpty()
                            || (!spinnerColorManufacturerOne.getSelectedItem().toString().isEmpty() && !editTextColorWeightOne.getText().toString().isEmpty())) {
                        if (spinnerColorManufacturerTwo.getSelectedItem().toString().isEmpty()
                                || (!spinnerColorManufacturerTwo.getSelectedItem().toString().isEmpty() && !editTextColorWeightTwo.getText().toString().isEmpty())) {
                            if (spinnerColorManufacturerThree.getSelectedItem().toString().isEmpty()
                                    || (!spinnerColorManufacturerThree.getSelectedItem().toString().isEmpty() && !editTextColorWeightThree.getText().toString().isEmpty())) {
                                if(spinnerColorManufacturerFour.getSelectedItem().toString().isEmpty()
                                        || (!spinnerColorManufacturerFour.getSelectedItem().toString().isEmpty() && !editTextColorWeightFour.getText().toString().isEmpty())){
                                    if (!editTextFormulaTime.getText().toString().isEmpty()) {
                                        if (!editTextFormulaPrice.getText().toString().isEmpty()) {

                                            formulaDao.insertFormula(formula);

                                            int customerId = customerDao.getMaxCustomerId();
                                            int formulaId = formulaDao.getMaxFormulaId();
                                            order = new Order(customerId, formulaId);

                                            orderDao.insertOrder(order);

                                            intent = new Intent(FormulaActivity.this, MainActivity.class);
                                            startActivity(intent);

                                        } else {
                                            editTextFormulaPrice.setError("Field is required");
                                        }

                                    }else {
                                        editTextFormulaTime.setError("Field is required");
                                    }

                                }else {
                                    editTextColorWeightFour.setError("Field is required");
                                }

                            } else {
                                editTextColorWeightThree.setError("Field is required");
                            }

                        } else {
                            editTextColorWeightTwo.setError("Field is required");
                        }

                    } else {
                        editTextColorWeightOne.setError("Field is required");
                    }

                } else {
                    editTextOxidantWeightTwo.setError("Field is required");
                }

            } else {
                editTextOxidantWeightOne.setError("Field is required");
            }

        });
    }

    private void createFormula() {
        int formulaTime;
        if (editTextFormulaTime.getText().toString().isEmpty()) {
            formulaTime = 0;
        } else {
            formulaTime = Integer.parseInt(editTextFormulaTime.getText().toString());
        }

        int formulaPrice;
        if (editTextFormulaPrice.getText().toString().isEmpty()) {
            formulaPrice = 0;
        } else {
            formulaPrice = Integer.parseInt(editTextFormulaPrice.getText().toString());
        }

        formula = new Formula(formulaTime, formulaPrice);
    }

    public void addOxidantToFormula(Spinner manufacturer, Spinner product, EditText weight) {
        String manufacturerString = manufacturer.getSelectedItem().toString();
        String oxidantString = product.getSelectedItem().toString();
        int weightInt;
        if (weight.getText().toString().isEmpty()) {
            weightInt = 0;
        } else {
            weightInt = Integer.parseInt(weight.getText().toString());
        }

        oxidant = new Oxidant(manufacturerString, oxidantString, weightInt);
        if (!manufacturerString.isEmpty()) {
            formula.add(oxidant);
        }
    }

    public void addColorToFormula(Spinner manufacturer, Spinner product, EditText weight) {
        String manufacturerString = manufacturer.getSelectedItem().toString();
        String oxidantString = product.getSelectedItem().toString();
        int weightInt;
        if (weight.getText().toString().isEmpty()) {
            weightInt = 0;
        } else {
            weightInt = Integer.parseInt(weight.getText().toString());
        }

        color = new Color(manufacturerString, oxidantString, weightInt);
        if (!manufacturerString.isEmpty()) {
            formula.add(color);
        }
    }

    @Override
    public void onBackPressed() {
    }
}