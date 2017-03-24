package com.nowaba.suporte.diariodebordo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button btNovo;
    private Button btEntrar;
    private EditText etUser;
    private EditText etSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btNovo = (Button) findViewById(R.id.btNew);
        btEntrar = (Button) findViewById(R.id.btEnter);
        etUser = (EditText) findViewById(R.id.etLogin);
        etSenha = (EditText) findViewById(R.id.etSenha);

        btNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoCad= new Intent(Login.this,CadastroUsuario.class);
                startActivity(novoCad);
            }
        });

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Caro "+etUser.getText().toString()+",\nLamentamos o incoveniente, já estamos providenciando a correção do Erro...",Toast.LENGTH_LONG).show();
                etSenha.setText("");
                etUser.requestFocus();
            }
        });


    }
}
