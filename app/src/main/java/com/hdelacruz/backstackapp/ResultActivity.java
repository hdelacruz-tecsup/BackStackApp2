package com.hdelacruz.backstackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView  codeText;
    private TextView fullanameText;
    private TextView amountText;
    private Button confirmButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        codeText = findViewById(R.id.code_text);
        fullanameText = findViewById(R.id.fullname_text);
        amountText = findViewById(R.id.amount_text);
        confirmButton = findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm();
            }
        });

        Bundle bundle= getIntent().getExtras();
        if(bundle !=null){

            int code = bundle.getInt("code");
            String fullname = bundle.getString("fullname");
            Double amount = bundle.getDouble("amount");

            codeText.setText(String.valueOf(code));
            fullanameText.setText(fullname);
            amountText.setText(String.valueOf(amount));
        }

    }
    private void confirm(){

        //Guardar en BD

        Intent intent =new Intent();
        intent.putExtra("result","Registro satisfactorio");
        setResult(RESULT_OK, intent);
        finish();

    }
}
