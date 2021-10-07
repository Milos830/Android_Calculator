package com.milos.coolcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    TextView resultView;

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }
    String runningNumber = "";
    String leftValue = "";
    String rightValue = "";
    Operation currentOperation;
    int result = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.Btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.Btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btn0 = findViewById(R.id.btn0);
        Button clearBtn = findViewById(R.id.clearBtn);

        ImageButton calcBtn = findViewById(R.id.calcBtn);
        ImageButton divideBtn = findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = findViewById(R.id.multiplyBtn);
        ImageButton substactBtn = findViewById(R.id.substactBtn);
        ImageButton addBtn = findViewById(R.id.addBtn);

        resultView = findViewById(R.id.resultsText);
        resultView.setText("0");


        btn1.setOnClickListener(view -> numberPressed(1));

        btn2.setOnClickListener(view -> numberPressed(2));

        btn3.setOnClickListener(view -> numberPressed(3));

        btn4.setOnClickListener(view -> numberPressed(4));

        btn5.setOnClickListener(view -> numberPressed(5));
        
        btn6.setOnClickListener(view -> numberPressed(6));

        btn7.setOnClickListener(view -> numberPressed(7));

        btn8.setOnClickListener(view -> numberPressed(8));

        btn9.setOnClickListener(view -> numberPressed(9));

        btn0.setOnClickListener(view -> numberPressed(0));

        calcBtn.setOnClickListener(view -> processOperation(Operation.EQUAL));

        divideBtn.setOnClickListener(view -> processOperation(Operation.DIVIDE));

        multiplyBtn.setOnClickListener(view -> processOperation(Operation.MULTIPLY));

        substactBtn.setOnClickListener(view -> processOperation(Operation.SUBTRACT));

        addBtn.setOnClickListener(view -> processOperation(Operation.ADD));

        clearBtn.setOnClickListener(view -> {
            leftValue = "";
            rightValue = "";
            resultView.setText("0");
            result = 0;
            runningNumber = "";
            currentOperation = null;
        });
    }

    void processOperation(Operation operation) {

        if(currentOperation != null) {
            if(runningNumber != null) {
                rightValue = runningNumber;
                runningNumber = "";

                switch (currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                        break;
                }
                leftValue = String.valueOf(result);
                resultView.setText(leftValue);
            }
        } else {
            leftValue = runningNumber;
            runningNumber = "";
        }
        currentOperation = operation;
    }

    void numberPressed(int number) {
        //take existing number and add new one to end of it
        runningNumber += String.valueOf(number);
        resultView.setText(runningNumber);
    }
}