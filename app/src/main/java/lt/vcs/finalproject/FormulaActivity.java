package lt.vcs.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormulaActivity extends AppCompatActivity {

    Button backButtonFormula;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);

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

}