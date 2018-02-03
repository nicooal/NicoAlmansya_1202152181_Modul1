package com.example.nico.studycase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "MAKMAL";
    String var_menu, nama_tempat;
    Integer var_porsi, total;
    EditText tMenu, tPorsi;
    Button btnEb, btnAbn;
    Bundle a,e;
    Integer hargaAbn = 30000;
    Integer hargaEb = 50000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tMenu = (EditText)findViewById(R.id.text_menu);
        tPorsi = (EditText)findViewById(R.id.text_porsi);
        btnEb = (Button)findViewById(R.id.btn_eb);
        btnAbn = (Button)findViewById(R.id.btn_abn);

        btnAbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                var_menu = tMenu.getText().toString();
                var_porsi = Integer.valueOf(tPorsi.getText().toString().trim());
                total = var_porsi * hargaAbn;
                nama_tempat = btnAbn.getText().toString();

                a = new Bundle();
                a.putString("parse_menu",var_menu);
                a.putInt("parse_porsi", var_porsi);
                a.putInt("parse_total", total);
                a.putString("parse_nama", nama_tempat);
                intent.putExtras(a);
                startActivity(intent);

                if(total < 65500) {
                    Toast pesan = Toast.makeText(MainActivity.this, "Disini aja makan malamnya", Toast.LENGTH_LONG);
                    pesan.show();
                } else {
                    Toast pesan = Toast.makeText(MainActivity.this, "Jangan disini makan malamnya, uang kamu tidak cukup", Toast.LENGTH_LONG);
                    pesan.show();
                }
            }
        });

        btnEb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                var_menu = tMenu.getText().toString();
                var_porsi = Integer.parseInt(tPorsi.getText().toString());
                total = var_porsi * hargaEb;
                nama_tempat = btnEb.getText().toString();

                e = new Bundle();
                e.putString("parse_menu",var_menu);
                e.putInt("parse_porsi",var_porsi);
                e.putInt("parse_total",total);
                e.putString("parse_nama", nama_tempat);
                intent.putExtras(e);
                startActivity(intent);

                if(total < 65500) {
                    Toast pesan = Toast.makeText(MainActivity.this, "Disini aja makan malamnya", Toast.LENGTH_LONG);
                    pesan.show();
                } else {
                    Toast pesan = Toast.makeText(MainActivity.this, "Jangan disini makan malamnya, uang kamu tidak cukup", Toast.LENGTH_LONG);
                    pesan.show();
                }
            }
        });
    }
}
