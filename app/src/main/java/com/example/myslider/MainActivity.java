package com.example.myslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private List<SliderItem> listItems;
    private ViewPager page;
    private TabLayout tabLayout;

    /*Slider Code*/
    String strImag[]= {"Android","Java","PHP","C","C++"};

    int imgData[] = {R.drawable.careerafter,R.drawable.ic_auto12,
            R.drawable.ic_service3,R.drawable.subject_combination,R.drawable.teaching_reedsws};
    private ArrayList<SliderItem> sliderItemArrayList;


    /*over Slider Code*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page = findViewById(R.id.my_pager) ;
        tabLayout = findViewById(R.id.my_tablayout);

        // Make a copy of the slides you'll be presenting.
        listItems = new ArrayList<SliderItem>() ;


        for (int i = 0; strImag.length > i; i++) {
            SliderItem sliderItem = new SliderItem(strImag[i], imgData[i]);
            listItems.add(sliderItem);
        }

        The_Slide_items_Pager_Adapter itemsPager_adapter = new The_Slide_items_Pager_Adapter(this, listItems);
        page.setAdapter(itemsPager_adapter);

        // The_slide_timer
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),2000,3000);
        tabLayout.setupWithViewPager(page,true);
    }

    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (page.getCurrentItem()< listItems.size()-1) {
                        page.setCurrentItem(page.getCurrentItem()+1);
                    }
                    else
                        page.setCurrentItem(0);
                }
            });
        }
    }
}