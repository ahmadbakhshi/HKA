package com.example.ahmad.hka_1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class
        adapter_item extends BaseAdapter {


    List<namayande> codeLearnChapterList = getDataForListView();


    public void clearlist()
    {
        codeLearnChapterList.clear();
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return codeLearnChapterList.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return codeLearnChapterList.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }


    @Override
    public View getView(final int arg0, View arg1, final ViewGroup arg2) {

        if(arg1==null)
        {
            LayoutInflater inflater = LayoutInflater.from(arg2.getContext());
            arg1 = inflater.inflate(R.layout.item1, arg2,false);
        }



        TextView namekandid= (TextView) arg1.findViewById(R.id.textView6);
        ImageView img=(ImageView) arg1.findViewById(R.id.imageView10);



        final namayande chapter = codeLearnChapterList.get(arg0);
        namekandid.setText(chapter.name);

        //img.setImageDrawable(chapter.pic);
        try{
            byte[] decodedString = Base64.decode(chapter.pic, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            img.setImageBitmap(decodedByte);
        }
        catch (Exception ex){}


        return arg1;


    }



    public List<namayande> getDataForListView()
    {
        List<namayande> codeLearnChaptersList = new ArrayList<namayande>();


        return codeLearnChaptersList;


    }

    public void addtolist(namayande it)
    {
        codeLearnChapterList.add(it);
    }

}
