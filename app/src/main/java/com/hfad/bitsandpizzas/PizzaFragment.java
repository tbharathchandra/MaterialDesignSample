package com.hfad.bitsandpizzas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaFragment extends Fragment {
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pizza,container,false);
       String[] pizzaNames = new String[pizza.pizzas.length];
       for(int i=0;i<pizzaNames.length;i++){
           pizzaNames[i]=pizza.pizzas[i].getName();
        }
        int[] pizzaImage = new int[pizzaNames.length];
       for(int i=0;i<pizzaNames.length;i++){
           pizzaImage[i]=pizza.pizzas[i].getImageResourceId();
       }
       CaptionedImageAdapter adapter = new CaptionedImageAdapter(pizzaNames,pizzaImage);
       pizzaRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        pizzaRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(),PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID,position);
                getActivity().startActivity(intent);
            }
        });
       return pizzaRecycler;
    }
}
