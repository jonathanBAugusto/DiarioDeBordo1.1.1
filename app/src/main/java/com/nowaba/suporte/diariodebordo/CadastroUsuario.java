package com.nowaba.suporte.diariodebordo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroUsuario extends AppCompatActivity {
    private Button btCancelar;
    private Button btEnviar;
    private EditText etNome;
    private EditText etUsuario;
    private EditText etSenha;
    private EditText etRsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        btCancelar = (Button)findViewById(R.id.btCancelar);
        btEnviar = (Button)findViewById(R.id.btEnviar);
        etNome = (EditText)findViewById(R.id.etNome);
        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etSenha = (EditText)findViewById(R.id.etSenha);
        etRsenha = (EditText)findViewById(R.id.etRsenha);

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroUsuario.this,Login.class);
                startActivity(intent);
                finish();
            }
        });

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                String nome = etNome.getText().toString();
                intent.putExtra("nome",nome);
                intent.putExtra("usuario",etUsuario.getText().toString());
                intent.putExtra("senha",etSenha.getText().toString());
                etNome.setText("");
                etUsuario.setText("");
                etSenha.setText("");
                etRsenha.setText("");
                Toast.makeText(getApplicationContext(),"Cadastro Realizado em nome de "+nome, Toast.LENGTH_LONG).show();
                startActivity(intent);


            }
        });
    }
}
