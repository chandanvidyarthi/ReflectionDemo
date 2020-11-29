package com.example.reflectiondemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reflectiondemo.model.BaseObjectResponse
import com.example.reflectiondemo.model.BusinessCardEntity
import com.example.reflectiondemo.model.Card
import com.example.reflectiondemo.businessAppModule.providers.CardProvider
import com.example.reflectiondemo.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.netree.marketing.viewModels.ViewModelBusinessPage
import java.io.IOException
import java.util.ArrayList

var baseObjectResponse : BaseObjectResponse? = null;
var mCardList: MutableList<Card>? = null
private lateinit var viewMd: ViewModelBusinessPage
lateinit var mBinding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init(){
        baseObjectResponse = BaseObjectResponse()
        baseObjectResponse = Gson().fromJson(loadJSONFromAsset("test.json"), BaseObjectResponse::class.java)
        mCardList = ArrayList()
        viewMd = ViewModelProviders.of(this).get(ViewModelBusinessPage::class.java)

        getBusinesssCards(this, baseObjectResponse!!.rows)

        mBinding.recyclerView!!.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mBinding.recyclerView.setHasFixedSize(true)
        mBinding.recyclerView.itemAnimator = DefaultItemAnimator()
        mBinding.recyclerView.adapter!!.addAll(getBusinesssCards(this, baseObjectResponse!!.rows))

        Log.d("Fasdfasdfas"," "+ getBusinesssCards(this, baseObjectResponse!!.rows))

    }


    fun getBusinesssCards(context: Context, dynamicBusinessPage: List<BusinessCardEntity>?): List<Card> {

        val cards = ArrayList<Card>()
        if (dynamicBusinessPage != null && dynamicBusinessPage.size > 0) {
            for (i in dynamicBusinessPage.indices) {
                val card = getCard(context, dynamicBusinessPage[i]) ?: continue
                cards.add(card)
                mCardList!!.add(card)
            }
        }

        return cards
    }

    private fun getCard(context: Context, businessCardEntity: BusinessCardEntity): Card? {
        try {
            val className = "com.example.reflectiondemo.businessAppModule.providers." + businessCardEntity.className
            val mProvider = Class.forName(className).newInstance() as CardProvider<*>
                ?: return null

            return Card.Builder(context, businessCardEntity, className).withProvider(mProvider)
                .setData(businessCardEntity)
                .endConfig()
                .build()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun loadJSONFromAsset(js: String): String? {
        var json: String? = null
        try {
            val `is` = this.getAssets().open(js)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

}