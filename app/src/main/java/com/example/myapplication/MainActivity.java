package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView calculatorScreenResult, calculatorScreen;
    Button C,CE;
    Button bdiv, bmult, badd, bsub, bequ;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorScreenResult = findViewById(R.id.calculatorScreenResult);
        calculatorScreen = findViewById(R.id.calculatorScreen);

        assignId(C, R.id.C);
        assignId(bdiv, R.id.bdiv);
        assignId(bmult, R.id.bmult);
        assignId(badd, R.id.badd);
        assignId(bsub, R.id.bsub);
        assignId(bequ, R.id.bequ);
        assignId(b0, R.id.b0);
        assignId(b1, R.id.b1);
        assignId(b2, R.id.b2);
        assignId(b3, R.id.b3);
        assignId(b4, R.id.b4);
        assignId(b5, R.id.b5);
        assignId(b6, R.id.b6);
        assignId(b7, R.id.b7);
        assignId(b8, R.id.b8);
        assignId(b9, R.id.b9);
        assignId(CE, R.id.CE);



    }

    void assignId(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = calculatorScreen.getText().toString();

        if (buttonText.equals("CE")) {
            calculatorScreen.setText("");
            calculatorScreenResult.setText("0");
            return;
        }
        if (buttonText.equals("=")) {
            calculatorScreen.setText(calculatorScreenResult.getText());
            return;
        }
        if (buttonText.equals("C")) {
            dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
        } else {
            dataToCalculate = dataToCalculate + buttonText;
        }
        calculatorScreen.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if (!finalResult.equals("Err")) {
            calculatorScreenResult.setText(finalResult);
        }

    }

    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (finalResult.endsWith(".0")) {
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        } catch (Exception e) {
            return "Err";
        }
    }

}