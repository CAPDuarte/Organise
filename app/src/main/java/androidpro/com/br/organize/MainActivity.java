package androidpro.com.br.organize;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
//import android.icu.util.Calendar;
import java.util.Calendar;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdicionarAtividade.class));
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG) //Foi comentado para ativar a atividade acima
                //        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Recupera dados digitados pelo usuário na classe AdicionarAtividade
        //https://stackoverflow.com/questions/36061438/how-to-pass-two-strings-from-one-activity-to-another-activity-in-android
                Intent intent = getIntent();
                String titulo = intent.getStringExtra("titulo");
                String texto = intent.getStringExtra("texto");
                String data = intent.getStringExtra("data");
                String hora = intent.getStringExtra("hora");
                String prioridade = intent.getStringExtra("prioridade");

                TextView tituloview = (TextView) findViewById(R.id.titulomain);
                TextView textoview = (TextView) findViewById(R.id.textomain);
                TextView dataview = (TextView) findViewById(R.id.datamain);
                TextView horaview = (TextView) findViewById(R.id.horamain);
                TextView prioridadeview = (TextView) findViewById(R.id.prioridademain);

                tituloview.setText(titulo);
                textoview.setText(texto);
                dataview.setText(data);
                horaview.setText(hora);
                prioridadeview.setText(prioridade);

        //tratando o calendário e o horário para trabalhar com o alarme

        }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_notas    ) {
            View view = new View(this);
            Intent Intent = new Intent(view.getContext(), Notas.class);
            view.getContext().startActivity(Intent);
        } else if (id == R.id.nav_lembretes) {
            View view = new View(this);
            Intent Intent = new Intent(view.getContext(), Lembretes.class);
            view.getContext().startActivity(Intent);

        } else if (id == R.id.nav_configuracao) {
            View view = new View(this);
            Intent Intent = new Intent(view.getContext(), Configuracoes.class);
            view.getContext().startActivity(Intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
