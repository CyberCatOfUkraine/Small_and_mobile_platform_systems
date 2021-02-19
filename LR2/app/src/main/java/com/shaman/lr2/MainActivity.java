package com.shaman.lr2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ResultEditText(){
        return findViewById(R.id.resultEditText);
    }
     EditText firstNumber(){
        return findViewById(R.id.firstTextNumber);
    }
    EditText secondNumber(){
        return findViewById(R.id.secondTextNumber);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plusBtn=findViewById(R.id.plusBtn);
        Button minusBtn=findViewById(R.id.minusBtn);
        Button multipleBtn=findViewById(R.id.multipleBtn);
        Button divideBtn=findViewById(R.id.divideBtn);
        Button clearBtn=findViewById(R.id.clearBtn);
        Button exitBtn=findViewById(R.id.exitBtn);

        plusBtn.setOnClickListener(x -> {
            if (firstNumber().getText()==null||firstNumber().getText().toString().equals("")){
                Toast toast = Toast.makeText(getApplicationContext(),R.string.insert_number, Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            double firstNumberValue=Double.parseDouble(String.valueOf(firstNumber().getText()));
            double secondNumberValue=Double.parseDouble(String.valueOf(secondNumber().getText()));
            PlusNumbers(firstNumberValue,secondNumberValue);
        });
        minusBtn.setOnClickListener(x -> {
            if (firstNumber().getText()==null||firstNumber().getText().toString().equals("")){
                Toast toast = Toast.makeText(getApplicationContext(),R.string.insert_number, Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            double firstNumberValue=Double.parseDouble(String.valueOf(firstNumber().getText()));
            double secondNumberValue=Double.parseDouble(String.valueOf(secondNumber().getText()));
            MinusNumbers(firstNumberValue,secondNumberValue);
        });
        multipleBtn.setOnClickListener(x -> {
            if (firstNumber().getText()==null||firstNumber().getText().toString().equals("")){
                Toast toast = Toast.makeText(getApplicationContext(),R.string.insert_number, Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            double firstNumberValue=Double.parseDouble(String.valueOf(firstNumber().getText()));
            double secondNumberValue=Double.parseDouble(String.valueOf(secondNumber().getText()));
            MultipleNumbers(firstNumberValue,secondNumberValue);
        });
        divideBtn.setOnClickListener(x -> {
            if (firstNumber().getText()==null||firstNumber().getText().toString().equals("")){
                Toast toast = Toast.makeText(getApplicationContext(),R.string.insert_number, Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            double firstNumberValue=Double.parseDouble(String.valueOf(firstNumber().getText()));
            double secondNumberValue=Double.parseDouble(String.valueOf(secondNumber().getText()));
            DivideNumbers(firstNumberValue,secondNumberValue);
        });
        clearBtn.setOnClickListener(x ->{
            firstNumber().setText("");
            secondNumber().setText("");
            ResultEditText().setText("");

        });
        exitBtn.setOnClickListener(x->{
            int pid = android.os.Process.myPid();
            android.os.Process.killProcess(pid);
        });
    }

    void PlusNumbers(double firstNumber,double secondNumber){
        double value=firstNumber+secondNumber;
        ResultEditText().setText(String.valueOf(value));
    }
    void MinusNumbers(double firstNumber,double secondNumber){
        double value=firstNumber-secondNumber;
        ResultEditText().setText(String.valueOf(value));
    }
    void MultipleNumbers(double firstNumber,double secondNumber){
        double value=firstNumber*secondNumber;
        ResultEditText().setText(String.valueOf(value));
    }
    void DivideNumbers(double firstNumber,double secondNumber){
        double value=firstNumber/secondNumber;
        ResultEditText().setText(String.valueOf(value));
    }
}