package com.christianquintero.practica_5;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class demografia extends AppCompatActivity {
    private ListView listView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demografia);
        drawerLayout = (DrawerLayout)findViewById(R.id.contenedorDrawerDemo);
        listView = (ListView)findViewById(R.id.menuIzq);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_list_item_1);
        listView.setAdapter(adaptador);

        final ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setHomeAsUpIndicator(android.R.drawable.ic_dialog_dialer);
            ab.setDisplayHomeAsUpEnabled(true);
        }

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
                        startActivity(i);;
                        break;
                    case 3:
                        i = new Intent(getApplicationContext(), sitiosActivity.class);
                        startActivity(i);
                        break;
                    case 4:
                        i = new Intent(getApplicationContext(), demografia.class);
                        startActivity(i);
                        break;
                }
                finish();
                drawerLayout.closeDrawer(listView);
            }
        });
    }
}
