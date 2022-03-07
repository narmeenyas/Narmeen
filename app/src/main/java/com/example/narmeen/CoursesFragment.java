package com.example.narmeen;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class CoursesFragment  extends Fragment implements DialogInterface.OnClickListener {

    private Intent musicIntent;
    private CardView helloCard;
    private CardView morningCard, basicCard,foodCard,drinksCard;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_courses,container, false);

        
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }
}
