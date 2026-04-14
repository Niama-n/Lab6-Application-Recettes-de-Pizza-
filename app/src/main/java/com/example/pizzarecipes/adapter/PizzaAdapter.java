package com.example.pizzarecipes.adapter;

import android.content.Context;
import android.view.*;
import android.widget.*;
import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import java.util.List;

/**
 * Adapter for displaying pizza products in a ListView.
 */
public class PizzaAdapter extends BaseAdapter {
    private final Context context;
    private final List<Produit> pizzaList;

    public PizzaAdapter(Context context, List<Produit> pizzaList) {
        this.context = context;
        this.pizzaList = pizzaList;
    }

    @Override public int getCount() { return pizzaList.size(); }
    @Override public Object getItem(int i) { return pizzaList.get(i); }
    @Override public long getItemId(int i) { return pizzaList.get(i).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate row layout if not recycled
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.row_pizza, parent, false);

        // Bind UI elements
        ImageView pizzaImage = convertView.findViewById(R.id.imgPizza);
        TextView nameText = convertView.findViewById(R.id.tvNom);
        TextView metaText = convertView.findViewById(R.id.tvMeta);

        // Get current pizza and set data
        Produit pizza = pizzaList.get(position);
        pizzaImage.setImageResource(pizza.getImageRes());
        nameText.setText(pizza.getName());
        metaText.setText(pizza.getDuration() + " • " + pizza.getPrice() + " €");

        return convertView;
    }
}
