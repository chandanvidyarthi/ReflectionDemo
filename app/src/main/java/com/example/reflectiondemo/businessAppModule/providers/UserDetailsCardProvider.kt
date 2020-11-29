package com.example.reflectiondemo.businessAppModule.providers

import android.view.View
import android.widget.TextView
import com.example.reflectiondemo.R
import com.example.reflectiondemo.model.BusinessCardEntity
import com.example.reflectiondemo.model.Card
import kotlinx.android.synthetic.main.user_details_card_provider.view.*


public class UserDetailsCardProvider : MainCardProvider() {

    override fun onCreated() {
        super.onCreated()
        layout = R.layout.user_details_card_provider

    }

    override fun render(view: View, card: Card) {
        super.render(view, card)
        val businessCardEntity = data as BusinessCardEntity
        val textHeading = findViewById<TextView>(view, R.id.text, TextView::class.java!!) as TextView
        val textName = findViewById<TextView>(view, R.id.text_name, TextView::class.java!!) as TextView
        val textEmail = findViewById<TextView>(view, R.id.text_email, TextView::class.java!!) as TextView
        val textDesignation = findViewById<TextView>(view, R.id.text_designation, TextView::class.java!!) as TextView
        textHeading.text = businessCardEntity.tittle
        textName.text = "Name : "+businessCardEntity.userDetails.name
        textEmail.text = "Email ID : "+businessCardEntity.userDetails.emailid
        textDesignation.text = "Designation : "+businessCardEntity.userDetails.designation
    }
}