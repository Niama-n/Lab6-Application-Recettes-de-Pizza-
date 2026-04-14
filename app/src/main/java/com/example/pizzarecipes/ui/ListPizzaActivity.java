package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.pizzarecipes.R;
import com.example.pizzarecipes.adapter.PizzaAdapter;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;
import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_list_pizza);

        // Configurer la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Bouton partage dans l'en-tête
        ImageButton shareBtn = findViewById(R.id.btnShareHeader);
        shareBtn.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Recettes Pizza");
            shareIntent.putExtra(Intent.EXTRA_TEXT,
                    "🍕 Découvrez nos délicieuses recettes de pizza dans l'app Pizza Recipes !");
            startActivity(Intent.createChooser(shareIntent, "Partager via"));
        });

        ListView lv = findViewById(R.id.lvPizzas);
        List<Produit> pizzas = ProduitService.getInstance().findAll();

        lv.setAdapter(new PizzaAdapter(this, pizzas));

        lv.setOnItemClickListener((parent, view, pos, id) -> {
            Intent it = new Intent(this, PizzaDetailActivity.class);
            it.putExtra("pizza_id", id);
            startActivity(it);
        });
    }
}