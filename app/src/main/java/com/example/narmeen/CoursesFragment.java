package com.example.narmeen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class CoursesFragment  extends Fragment {

    private CardView helloCard;
    private CardView morningCard, chatCard, foodCard, drinksCard, foodmoreCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_courses, container, false);
        helloCard = (CardView) v.findViewById(R.id.helloCard);
        chatCard = (CardView) v.findViewById(R.id.chatCard);
        morningCard = (CardView) v.findViewById(R.id.morningCard);
        foodCard = (CardView) v.findViewById(R.id.foodCard);
        drinksCard = (CardView) v.findViewById(R.id.drinksCard);
        foodmoreCard = (CardView) v.findViewById(R.id.foodmoreCard);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        helloCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "helloCard");
                startActivity(i);
            }
        });
        morningCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "morningCard");
                startActivity(i);
            }
        });
        chatCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "chatCard");
                startActivity(i);
            }
        });
        foodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "foodCard");
                startActivity(i);
            }
        });
        drinksCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "drinksCard");
                startActivity(i);
            }
        });
        foodmoreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("name", "foodmoreCard");
                startActivity(i);
            }
        });
    }

}