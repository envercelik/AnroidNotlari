package com.celik.app04odev3layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewCityName;
    TextView textViewCityLicencePlate;
    TextView textViewCityDescription;

    ImageView imageViewCityImage;

    ImageButton imageButtonLeftArrow;
    ImageButton imageButtonRightArrow;


    String[] cityNames;
    String[] cityLicencePlates;
    String[] cityDescription;
    TypedArray cityImages;


    int cityIndex = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializes();
        setSlideArrowStatus();
        setCity();

    }


    public void setSlideArrowStatus(){

        imageButtonLeftArrow.setVisibility(View.VISIBLE);
        imageButtonRightArrow.setVisibility(View.VISIBLE);

        if (cityIndex==0) {
            imageButtonLeftArrow.setVisibility(View.INVISIBLE);
        }

        if (cityIndex == cityNames.length-1) {
            imageButtonRightArrow.setVisibility(View.INVISIBLE);
        }

    }

    public void nextCity(View view){
        cityIndex++;
        setCity();
        setSlideArrowStatus();
    }

    public void previousCity(View view) {

        cityIndex--;
        setCity();
        setSlideArrowStatus();
    }

    public void setCity(){

        textViewCityName.setText(cityNames[cityIndex]);
        textViewCityLicencePlate.setText(cityLicencePlates[cityIndex]);
        textViewCityDescription.setText(cityDescription[cityIndex]);           //default value
        imageViewCityImage.setImageResource(cityImages.getResourceId(cityIndex,R.drawable.istanbul));

    }

    public void initializes() {

        //ui-initializes
        textViewCityName = findViewById(R.id.text_view_city_name);
        textViewCityLicencePlate = findViewById(R.id.text_view_licence_plate);
        textViewCityDescription = findViewById(R.id.text_view_description);
        imageViewCityImage = findViewById(R.id.image_view_city_image);
        imageButtonLeftArrow = findViewById(R.id.image_button_left_arrow);
        imageButtonRightArrow = findViewById(R.id.image_button_right_arrow);

        //initializes for cities
        cityNames = getResources().getStringArray(R.array.city_names);
        cityLicencePlates = getResources().getStringArray(R.array.city_licence_plates);
        cityDescription = getResources().getStringArray(R.array.city_descriptions);
        cityImages = getResources().obtainTypedArray(R.array.city_images);

    }




}