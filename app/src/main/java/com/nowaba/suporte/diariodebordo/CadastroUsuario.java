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
    private EditText etEmail;
    private boolean vEmail;

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
        etEmail = (EditText)findViewById(R.id.etEmail);

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

                if(etNome.getText().toString()!=null&&etNome.getText().toString()!=""){
                    if(etUsuario.getText().toString()!=null&&etUsuario.getText().toString()!=""){
                        if(etEmail.getText().toString()!=null&&etEmail.getText().toString()!="") {
                            vEmail = ValidaCpfEmail.validaEmail(etEmail.getText().toString());

                            if(vEmail) {
                                if (etSenha.getText().toString() != null && etSenha.getText().toString() != "") {

                                    if (etSenha.getText().toString().length() <= 16 || etSenha.getText().toString().length() >= 8) {
                                        if (etRsenha.getText().toString().equals(etSenha.getText().toString())) {
                                            Intent intent = new Intent(getApplicationContext(),Login.class);
                                            String nome = etNome.getText().toString();
                                            intent.putExtra("nome", nome);
                                            intent.putExtra("usuario", etUsuario.getText().toString());
                                            intent.putExtra("senha", etSenha.getText().toString());
                                            intent.putExtra("email", etEmail.getText().toString());
                                            Toast.makeText(getApplicationContext(),"Cadastro Realizado em nome de "+nome, Toast.LENGTH_LONG).show();
                                            startActivity(intent);
                                            finish();
                                            etNome.setText("");
                                            etUsuario.setText("");
                                            etSenha.setText("");
                                            etRsenha.setText("");
                                            etEmail.setText("");
                                        } else {
                                            etRsenha.setError("As senhas devem ser iguais!");
                                        }
                                    } else {
                                        etSenha.setError("A Senha deve conter 8 a 16 caracteres... ");
                                        etSenha.requestFocus();

                                    }
                                } else {
                                    etSenha.setError("Preencha o Campo \"Senha\"! ");
                                    etSenha.requestFocus();
                                }
                            }else{
                                etEmail.setError("Preencha o Campo \"Email\" sobre o modelo exemplo@exemplo.com");
                                etEmail.requestFocus();
                            }
                        }else{
                            etEmail.setError("Preencha o Campo \"Email\"");
                            etEmail.requestFocus();
                        }
                    }else{
                        etUsuario.setError("Preencha o Campo \"Usuario\"! ");
                        etUsuario.requestFocus();
                    }
                }else{
                    etNome.setError("Preencha o Campo \"Nome\"! ");
                    etNome.requestFocus();
                }



            }
        });
    }
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
        finish();
    }
}
