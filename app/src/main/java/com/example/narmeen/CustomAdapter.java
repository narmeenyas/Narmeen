package com.example.narmeen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter <Item> {
    private Context context;
    private int resource;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;//this is the item row resource , the design for each row
    }
    /*

     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(resource, parent, false);
        }
        Item item = getItem(position);//method from the android studio , not realted to item object
        if (item != null) {
            ImageView imageView = view.findViewById(R.id.imageItem);
            TextView textViewDescription = view.findViewById(R.id.textViewDesc);
            Button itemButton = view.findViewById(R.id.itemButton);
            itemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "this item was added to whatever", Toast.LENGTH_SHORT).show();
                }
            });
            imageView.setImageResource(item.getResid());
            textViewDescription.setText(item.getDescription());
        }
      return view;
    }
}
