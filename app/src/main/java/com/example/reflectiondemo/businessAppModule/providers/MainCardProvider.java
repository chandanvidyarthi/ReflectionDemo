package com.example.reflectiondemo.businessAppModule.providers;

import android.view.View;

import androidx.annotation.NonNull;

import com.example.reflectiondemo.businessAppModule.providers.CardProvider;
import com.example.reflectiondemo.model.Card;

public class MainCardProvider extends CardProvider {


    @Override
    public void render(@NonNull final View view, @NonNull final Card card) {
        super.render(view, card);
    }
}
