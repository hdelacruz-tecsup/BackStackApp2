package com.hdelacruz.backstackapp;

import android.content.Intent;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText codeInput;

    private EditText fullnameInput;

    private EditText amountIput;

    private Button sendButton;

    private TextView resultText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codeInput = findViewById(R.id.code_input);
        fullnameInput = findViewById(R.id.fullname_input);
        amountIput = findViewById(R.id.amount_input);
        sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });

        resultText = findViewById(R.id.result_text);

    }
    private void send(){

        String code = codeInput.getText().toString();
        String fullname = fullnameInput.getText().toString();
        String amount = amountIput.getText().toString();

        if(code.isEmpty()){

            codeInput.setError("Completar el codigo");
            codeInput.requestFocus();
            Toast.makeText(this, "Completar el Codigo", Toast.LENGTH_SHORT).show();
            return;
        }

        if(fullname.isEmpty()){

            fullnameInput.setError("Completar los nombres");
            fullnameInput.requestFocus();
            Toast.makeText(this, "Completar los nombres", Toast.LENGTH_SHORT).show();
            return;
        }
        if(amount.isEmpty()){
            amountIput.setError("Completar el Monto");
            amountIput.requestFocus();
            Toast.makeText(this, "Completar el monto", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("code", Integer.parseInt(code));

        intent.putExtra("fullname", fullname);
        intent.putExtra("amount", Double.parseDouble(amount));
//        startActivity(intent);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            if(resultCode == RESULT_OK);
            String result = data.getExtras().getString("result");

            resultText.setText(result);
        }
    }
}
