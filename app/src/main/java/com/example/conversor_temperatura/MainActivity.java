
package com.example.conversor_temperatura;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;

public class MainActivity extends AppCompatActivity {

    private EditText temperatureInput;
    private RadioGroup radioGroup;
    private RadioButton radioCelsiusToFahrenheit;
    private RadioButton radioFahrenheitToCelsius;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        temperatureInput = findViewById(R.id.temperatureInput);
        radioGroup = findViewById(R.id.radioGroup);
        radioCelsiusToFahrenheit = findViewById(R.id.radioCelsiusToFahrenheit);
        radioFahrenheitToCelsius = findViewById(R.id.radioFahrenheitToCelsius);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = temperatureInput.getText().toString();
                if (input.isEmpty()) {
                    resultTextView.setText("Por favor, insira um valor.");
                    return;
                }
                double temperature = Double.parseDouble(input);
                if (radioCelsiusToFahrenheit.isChecked()) {
                    double result = (temperature * 9/5) + 32;
                    resultTextView.setText(String.format("%.2f °F", result));
                } else if (radioFahrenheitToCelsius.isChecked()) {
                    double result = (temperature - 32) * 5/9;
                    resultTextView.setText(String.format("%.2f °C", result));
                } else {
                    resultTextView.setText("Selecione um tipo de conversão.");
                }
            }
        });
    }
}
