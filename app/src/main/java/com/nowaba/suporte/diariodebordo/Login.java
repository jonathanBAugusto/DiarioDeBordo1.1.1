package com.nowaba.suporte.diariodebordo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button btSair;
    private Button btEntrar;
    private EditText etUser;
    private EditText etSenha;
    private TextView tvCadastrar;
    private String nome, usuario, email, senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btSair = (Button) findViewById(R.id.btSair);
        btEntrar = (Button) findViewById(R.id.btEnter);
        etUser = (EditText) findViewById(R.id.etLogin);
        etSenha = (EditText) findViewById(R.id.etSenha);
        tvCadastrar = (TextView) findViewById(R.id.tvCadastrar);

        Bundle extra = getIntent().getExtras();

        if(extra!=null){
            nome = extra.getString("nome");
            usuario = extra.getString("usuario");
            email = extra.getString("email");
            senha = extra.getString("senha");
        }

        tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novoCad= new Intent(Login.this,CadastroUsuario.class);
                startActivity(novoCad);
            }
        });

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUser.getText().toString().equals("admin")&&etSenha.getText().toString().equals("admin")){
                    Intent intent = new Intent(getApplicationContext(),MainMenuActivity.class);
                    intent.putExtra("nome","Admin");
                    intent.putExtra("email","admin@insepar.com.br");
                    startActivity(intent);
                    finish();
                }else if(etUser.getText().toString()!=null&&etUser.getText().toString().equals(usuario)&&!etUser.getText().toString().equals(R.string.htUsuario)) {
                        if(etSenha.getText().toString()!=null&&etSenha.getText().toString().equals(senha)&&!etSenha.getText().toString().equals(R.string.htSenha)){
                            Intent intent = new Intent(getApplicationContext(),MainMenuActivity.class);
                            intent.putExtra("nome",nome);
                            intent.putExtra("email",email);
                            startActivity(intent);
                            finish();

                        }else {
                            etSenha.setError("Usuario ou senha incorretos ou inexistentes");
                            etSenha.requestFocus();
                        }
                    }else {
                        etUser.setError("Usuario ou senha incorretos ou inexistentes");
                        etUser.requestFocus();
                    }
            }
        });

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

    }
    public void onBackPressed() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}


