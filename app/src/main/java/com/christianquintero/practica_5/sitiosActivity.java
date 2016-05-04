package com.christianquintero.practica_5;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
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
import android.widget.ListView;
import android.widget.Toast;

public class sitiosActivity extends AppCompatActivity {
    private ViewPager pagerSitios;
    private ActionBar actionBar;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);

        drawerLayout = (DrawerLayout)findViewById(R.id.contenedorDrawerSitios);
        PageAdapterSitios adapder = new PageAdapterSitios(getSupportFragmentManager());
        pagerSitios = (ViewPager)findViewById(R.id.pagerSitios);
        pagerSitios.setAdapter(adapder);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setTitle(R.string.sitiosTuristicos);
        //pongo un boton en el actionBAr
        if(actionBar != null){
            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_dialog_dialer);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        listView = (ListView)findViewById(R.id.menuIzqSitios);
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


        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                pagerSitios.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        ActionBar.Tab tab = actionBar.newTab().setText("Isla Guaca").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Represa Guatapé").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Piedra del Peñol").setTabListener(tabListener);
        actionBar.addTab(tab);

        pagerSitios.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
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
        }
        return super.onOptionsItemSelected(item);
    }

    public void bSitio1(View view){
        //Toast.makeText(this, "sitio 1", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("Latitud", 6.21999);
        i.putExtra("Longitud", -75.190537);
        i.putExtra("destino", "Isla Guaca");
        startActivity(i);
    }

    public void bSitio2(View view){
        //Toast.makeText(this, "sition 2", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("Latitud", 6.269434 );
        i.putExtra("Longitud", -75.18322);
        i.putExtra("destino", "Represa Guatapé");
        startActivity(i);
    }

    public void bSitio3(View view){
        //Toast.makeText(this, "sitio 3", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("Latitud",  6.223612);
        i.putExtra("Longitud", -75.178183);
        i.putExtra("destino", "Piedra del Peñol");
        startActivity(i);
    }
}
