package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

/**
 * Activity that displays the detailed information of a selected pizza.
 */
public class PizzaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        // Configurer la Toolbar comme ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Retrieve the pizza ID from the intent extras
        long pizzaId = getIntent().getLongExtra("pizza_id", -1);

        // Fetch the pizza object from the service
        Produit pizza = ProduitService.getInstance().findById(pizzaId);

        // Bind UI components
        ImageView pizzaImageView = findViewById(R.id.img);
        TextView titleTextView = findViewById(R.id.title);
        TextView metaTextView = findViewById(R.id.meta);
        TextView ingredientsTextView = findViewById(R.id.ingredients);
        TextView descriptionTextView = findViewById(R.id.desc);
        TextView stepsTextView = findViewById(R.id.steps);
        ImageButton shareButton = findViewById(R.id.btnShare);

        // Update UI if pizza exists
        if (pizza != null) {
            pizzaImageView.setImageResource(pizza.getImageRes());
            titleTextView.setText(pizza.getName());
            metaTextView.setText(pizza.getDuration() + " • " + pizza.getPrice() + " €");
            ingredientsTextView.setText(pizza.getIngredients());
            descriptionTextView.setText(pizza.getDescription());
            stepsTextView.setText(pizza.getSteps());

            // Bouton partage
            final Produit finalPizza = pizza;
            shareButton.setOnClickListener(v -> {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Recettes Pizza");
                shareIntent.putExtra(Intent.EXTRA_TEXT,
                        "🍕 " + finalPizza.getName() + "\n⏱ " + finalPizza.getDuration() +
                        "\n\nIngrédients:\n" + finalPizza.getIngredients());
                startActivity(Intent.createChooser(shareIntent, "Partager via"));
            });

        } else {
            titleTextView.setText("Pizza not found!");
        }
    }
}
