package com.christianquintero.practica_5;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class baresActivity extends AppCompatActivity {
    private ViewPager pagerBares;
    private ActionBar actionBar;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bares);

        drawerLayout = (DrawerLayout)findViewById(R.id.contenedorDrawerBares);
        PageAdapterBares adapter = new PageAdapterBares(getSupportFragmentManager());
        pagerBares = (ViewPager)findViewById(R.id.pagerBares);
        pagerBares.setAdapter(adapter);



        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.bares);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        if(actionBar != null){
            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_dialog_dialer);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        listView = (ListView)findViewById(R.id.menuIzqBar);
        ArrayAdapter<CharSequence> listaAdaptador = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_list_item_1);
        listView.setAdapter(listaAdaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                switch (position){
                    case 0:
                        i = new Intent(getApplicationContext(), home.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(getApplicationContext(), hotelesActivity.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(getApplicationContext(), baresActivity.class);
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(getApplicationContext(), sitiosActivity.class);
                        startActivity(i);
                        break;
                    case 4:
                        i=new Intent(getApplicationContext(), demografia.class);
                        startActivity(i);
                        break;
                }
                finish();
                drawerLayout.closeDrawer(listView);
            }
        });


        //tab listener q se llama cuando se preciona uno de los tabs, tambien genera el espacio para los tabs
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                pagerBares.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        //creamos los tabs que se ulilizaran y se ponen en el espacio ya creado
        ActionBar.Tab tab = actionBar.newTab().setText("Bodeguetta").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("El Sacristan").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Tierra Dentro").setTabListener(tabListener);
        actionBar.addTab(tab);

        //activamos el listener para que cuando pasemos cada bar se pase igual en el ActionBar
        pagerBares.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            public void onPageSelected(int position){
                getSupportActionBar().setSelectedNavigationItem(position);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, android.R.drawable.ic_dialog_dialer, R.string.abierto, R.string.cerradp);
        drawerLayout.setDrawerListener(drawerToggle);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void bBar1(View view){
        //Toast.makeText(this, "Boton del primar bar", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("Latitud", 6.216968);
        i.putExtra("Longitud", -75.244176);
        i.putExtra("destino", "Bodeguetta Bar");
        startActivity(i);
    }

    public void bBar2(View view){
        //Toast.makeText(this, "Boton del segundo bar", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("Latitud", 6.182155);
        i.putExtra("Longitud", -75.297344);
        i.putExtra("destino", "Bar El Sacristan");
        startActivity(i);
    }

    public void bBar3(View view){
        //Toast.makeText(this, "Boton del tercer bar", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("Latitud", 6.13938 );
        i.putExtra("Longitud", -75.265663);
        i.putExtra("destino", "Tierra Dentro Bar");
        startActivity(i);
    }


}
