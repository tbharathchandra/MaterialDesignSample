package com.hfad.bitsandpizzas;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaDetailActivity extends AppCompatActivity {
    public static final String EXTRA_PIZZA_ID="pizzaId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //Display details of pizza
        int pizzaId = getIntent().getExtras().getInt(EXTRA_PIZZA_ID);
        String pizzaName = pizza.pizzas[pizzaId].getName();
        TextView textview  = (TextView) findViewById(R.id.pizza_text);
        textview.setText(pizzaName);
        int id=pizza.pizzas[pizzaId].getImageResourceId();
        ImageView imageView = (ImageView) findViewById(R.id.pizza_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this,id));
        imageView.setContentDescription(pizzaName);
    }
}
