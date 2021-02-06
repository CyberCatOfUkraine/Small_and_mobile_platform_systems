package com.shaman.lr1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    enum LocaleMode{
        UA,US,Other
    }
    LocaleMode _localeMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        Locale locale= res.getConfiguration().locale;

        switch (locale.getCountry().toUpperCase()){
            case "UA":
                _localeMode=LocaleMode.UA;
                break;
            case "US":
                _localeMode=LocaleMode.US;
                break;
            default:
                _localeMode=LocaleMode.Other;
                break;
        }
        try {
            ChangeItemsToLocale();
        }catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    e.getMessage(), Toast.LENGTH_LONG);
            toast.show();
            System.out.println("\n====");
            System.out.println(e.getMessage());
            System.out.println("====");
        }

    }

    private void ChangeItemsToLocale() {
        switch (_localeMode) {
            case UA:
                SetToolbarTitle(R.string.app_name_ukr);
                SetCreatorName(R.string.creator_name_ukr);
                SetEmblemImage(R.drawable.ua_emblem);
                SetFlaggeImage(R.drawable.ua_flagge);
                break;
            case US:
                SetToolbarTitle(R.string.app_name_eng);
                SetCreatorName(R.string.creator_name_eng);
                SetEmblemImage(R.drawable.usa_emblem);
                SetFlaggeImage(R.drawable.usa_flagge);
                break;
            case Other:
                SetToolbarTitle(R.string.app_name_eng);
                SetCreatorName(R.string.creator_name_eng);
                SetEmblemImage(R.drawable.world_emblem);
                SetFlaggeImage(R.drawable.world_flagge);
                break;
        }
    }
    void SetFlaggeImage(int resourceId){
        ImageView imageView =findViewById(R.id.flaggeImageView);
        imageView.setImageResource(resourceId);
    }
    void SetEmblemImage(int resourceId){
        ImageView imageView =findViewById(R.id.emblemImageView);
        imageView.setImageResource(resourceId);
    }

    void SetCreatorName(int resourceId){
        TextView textView=findViewById(R.id.creatorNameTextView);
        textView.setText(resourceId);
    }
    void SetToolbarTitle(int resourceId){

        androidx.appcompat.widget.Toolbar  toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbarExample);
       toolbar.setTitle(resourceId);
    }
}