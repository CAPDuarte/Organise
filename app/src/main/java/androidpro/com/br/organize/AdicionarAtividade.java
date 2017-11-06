package androidpro.com.br.organize;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidpro.com.br.organize.database.DatabaseController;

public class AdicionarAtividade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_atividade);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.adicionar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText titulo = (EditText) findViewById(R.id.titulo);
                EditText texto = (EditText) findViewById(R.id.texto);
                EditText data = (EditText) findViewById(R.id.data);
                EditText hora = (EditText) findViewById(R.id.hora);
                RatingBar prioridade = (RatingBar) findViewById(R.id.prioridade);
                String tituloString = titulo.getText().toString();
                String textoString = texto.getText().toString();
                String dataString = data.getText().toString();
                String horaString = hora.getText().toString();
                float prioridadefloat = prioridade.getRating();
                String prioridadeString = String.valueOf(prioridadefloat);

                //Passando dados digitados pelo usuário para a classe main
                        Intent intent = new Intent(AdicionarAtividade.this, MainActivity.class);
                        intent.putExtra("titulo",tituloString);
                        intent.putExtra("texto",textoString);
                        intent.putExtra("data",dataString);
                        intent.putExtra("hora",horaString);
                        intent.putExtra("prioridade",prioridadeString);
                        AdicionarAtividade.this.startActivity(intent);
            }
        });
    }
}
