package com.example.myslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class The_Slide_items_Pager_Adapter extends PagerAdapter {

    private Context Mcontext;
    private List<SliderItem> theSlideItemsModelClassList;

    public The_Slide_items_Pager_Adapter(Context Mcontext, List<SliderItem> theSlideItemsModelClassList) {
        this.Mcontext = Mcontext;
        this.theSlideItemsModelClassList = theSlideItemsModelClassList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) Mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = inflater.inflate(R.layout.item_layout,null);

        ImageView featured_image = sliderLayout.findViewById(R.id.my_featured_image);
        TextView caption_title = sliderLayout.findViewById(R.id.my_caption_title);

        featured_image.setImageResource(theSlideItemsModelClassList.get(position).getImgData());
        caption_title.setText(theSlideItemsModelClassList.get(position).getStrImag());
        container.addView(sliderLayout);
        return sliderLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return theSlideItemsModelClassList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
