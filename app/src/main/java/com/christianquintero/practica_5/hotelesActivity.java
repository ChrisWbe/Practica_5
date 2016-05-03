package com.christianquintero.practica_5;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class hotelesActivity extends AppCompatActivity {
    private ViewPager pagerHoteles;
    private ActionBar actionBar;
    private ListView listView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles);

        drawerLayout = (DrawerLayout)findViewById(R.id.contenedorDrawerHoteles);
        PageAdapterHoteles adapter = new PageAdapterHoteles(getSupportFragmentManager());
        pagerHoteles = (ViewPager)findViewById(R.id.pagerHoteles);
        pagerHoteles.setAdapter(adapter);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        if(actionBar != null){
            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_dialog_dialer);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        listView = (ListView)findViewById(R.id.menuIzq);
        final ArrayAdapter<CharSequence> listaAdaptador = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_list_item_1);
        listView.setAdapter(listaAdaptador);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                pagerHoteles.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        ActionBar.Tab tab = actionBar.newTab().setText("Casa Cayam").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Guatatur").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Piedra Santa").setTabListener(tabListener);
        actionBar.addTab(tab);

        pagerHoteles.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            public void onPageSelected(int position){
                getSupportActionBar().setSelectedNavigationItem(position);
            }
        });

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
    }

    public void bHotel1(View view){
        //Toast.makeText(this, "hotel 1", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("Latitud", 6.233966);
        i.putExtra("Longitud", -75.149864);
        i.putExtra("destino", "Hostal Casa Cayam");
        startActivity(i);
    }

    public void bHotel2(View view){
        //Toast.makeText(this, "hotel 2", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("Latitud", 6.234199);
        i.putExtra("Longitud", -75.162059);
        i.putExtra("destino", "Hotel Guatatur");
        startActivity(i);
    }

    public void bHotel3(View view){
        //Toast.makeText(this, "hotel 3", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("Latitud", 6.271678);
        i.putExtra("Longitud", -75.203573);
        i.putExtra("destino", "Hotel Piedra Santa");
        startActivity(i);
    }
}
