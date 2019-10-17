package com.example.myntrago;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.List;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle extras=getIntent().getExtras();
        int i=extras.getInt("Key1");
        TextView pro = (TextView) findViewById(R.id.promocode);
        TextView n=(TextView)findViewById(R.id.name);
        TextView va=(TextView)findViewById(R.id.valid);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> val = databaseAccess.getValidity();
        List<String> prom=databaseAccess.getPromoCode();
        List<String> name=databaseAccess.getProdName();

        databaseAccess.close();


        pro.setText(prom.get(i));
        va.setText(val.get(i));
        n.setText(name.get(i));

    }


}
