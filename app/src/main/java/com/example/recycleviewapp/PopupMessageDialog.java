package com.example.recycleviewapp;

import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class PopupMessageDialog extends Dialog {

    private TextView nameTextView;
    private TextView descriptionTextView;
    private ImageView imageView;

    public PopupMessageDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.popup_message);

        nameTextView = findViewById(R.id.popup_name);
        descriptionTextView = findViewById(R.id.popup_description);
        imageView = findViewById(R.id.popup_image);
    }

    public void setData(String name, String description, int imageResId) {
        nameTextView.setText(name);
        descriptionTextView.setText(description);
        imageView.setImageResource(imageResId);
    }

}
