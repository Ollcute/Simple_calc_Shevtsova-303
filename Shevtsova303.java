package com.example.calc_simple;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Shevtsova303 extends AppCompatActivity {
    TextView Result; // текстовое поле для вывода результата
    EditText number_a; // ввод переменной 1
    EditText number_b; // ввод переменной 2
    EditText number_c; //ввод переменной для мат функций
    EditText number_Pow; //ввод переменной для мат функций

    //кнопки
    private Button b_plus;
    private Button b_min;
    private Button b_delit;
    private Button b_proizv;
    private Button b_Sin;
    private Button b_Cos;
    private Button b_Tan;
    private Button b_Sqrt;
    private Button b_Pow;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // получаем все поля по id из activity_main.xml
        Result = findViewById(R.id.textView_Result);
        number_a = findViewById(R.id.number_a);
        number_b = findViewById(R.id.number_b);
        number_c = findViewById(R.id.number_c);
        number_Pow = findViewById(R.id.number_Pow);
        b_plus = findViewById(R.id.b_plus);
        b_min = findViewById(R.id.b_minus);
        b_delit = findViewById(R.id.b_delit);
        b_proizv= findViewById(R.id.b_proizv);
        b_Sin = findViewById(R.id.b_Sin);
        b_Cos = findViewById(R.id.b_Cos);
        b_Tan = findViewById(R.id.b_Tan);
        b_Sqrt = findViewById(R.id.b_Sqrt);
        b_Pow = findViewById(R.id.b_Pow);

    }
    //обработать нажатия
    @SuppressLint("SetTextI18n")
    public void doAdd(View v){

        //Вводим переменные, с которыми будем оперировать:
        float value_a;
        float value_b;
        float result = 0;

        //Принимаем значения для value1 и value2 с элементов ввода:
        value_a=Float.parseFloat(number_a.getText().toString());
        value_b=Float.parseFloat(number_b.getText().toString());


        //Описываем действия кнопок:
        switch (v.getId()) {
            case R.id.b_plus:
                result = value_a + value_b;
                break;
            case R.id.b_minus:
                result = value_a - value_b;
                break;
            case R.id.b_proizv:
                result = value_a * value_b;
                break;
            case R.id.b_delit:
                if(value_b!=0){
                    result = value_a / value_b;
                }
                else{
                    createDialog("Делить на 0 нельзя!");
                }

                break;
            default:
                break;
        }
        //настраиваем отображение результата:
        Result.setText(" = " + result);
    }
    public void Mathfunct(View v) {
        double value_c;
        double result2 = 0;
        double value_Pow;
        value_c = Double.parseDouble(number_c.getText().toString());


        switch (v.getId()) {
            case R.id.b_Sin:
                result2 = Math.sin(value_c);
                break;
            case R.id.b_Cos:
                result2 = Math.cos(value_c);
                break;
            case R.id.b_Tan:
                result2 = Math.tan(value_c);
                break;
            case R.id.b_Pow:
                value_Pow = Double.parseDouble(number_Pow.getText().toString());
                result2 = Math.pow(value_c, value_Pow);
                break;
            case R.id.b_Sqrt:
                if (value_c>0){
                    result2 = Math.sqrt(value_c);
                }
                else{
                    createDialog("Из отрицательного числа нельзя получить корень!");
                }
                result2 = Math.sqrt(value_c);
                break;
            default:
                break;
        }
        Result.setText(" = " + result2);
    }

    private void createDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Что-то пошло не так...").setMessage(message).setPositiveButton("Ок", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) { }
        }); builder.create().show(); }
}
