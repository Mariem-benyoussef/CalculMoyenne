package com.example.tp01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    Button boutonCalculer, boutonEffacer;

    EditText txtDC, txtDS;
    TextView txtmoy;

    View.OnClickListener effacerListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            txtmoy.setText("Moyenne=");
            txtDC.setText("");
            txtDS.setText("");
        }
    };
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            try {
                Float DC = Float.valueOf(txtDC.getText().toString());
                Float DS = Float.valueOf(txtDS.getText().toString());
                float moy = (DC*20 + DS * 80)/100;
                DecimalFormat formatter = new DecimalFormat("0.00");
                txtmoy.setText("MOYENNE= "+String.valueOf(formatter.format(moy)));
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    };

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boutonCalculer =  findViewById(R.id.moyenne);
        boutonEffacer = findViewById(R.id.effacer);
        boutonCalculer.setOnClickListener(listener);
        boutonEffacer.setOnClickListener(effacerListener);
        txtDC = findViewById(R.id.txtDC);
        txtDS = findViewById(R.id.txtDS);
        txtmoy = findViewById(R.id.txtmoy);
    }
}
