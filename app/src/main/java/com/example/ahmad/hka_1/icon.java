package com.example.ahmad.hka_1;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class icon extends Activity {

    public Integer[] myImages = {

            R.drawable.l1,
            R.drawable.l2,
            R.drawable.l3,
            R.drawable.l4,
            R.drawable.l5,
            R.drawable.l6,
            R.drawable.l7,
            R.drawable.l8,
            R.drawable.l9,
            R.drawable.l10,
            R.drawable.l11,
            R.drawable.l12,
            R.drawable.l13,
            R.drawable.l14,
            R.drawable.l15,
            R.drawable.l16,
            R.drawable.l17,
            R.drawable.l18,
            R.drawable.l19,
            R.drawable.l20,
            R.drawable.l21,
            R.drawable.l22,
            R.drawable.l23,







    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        final ImageView imgview= (ImageView) findViewById(R.id.imgview);

        gridview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


                String position_string = "you pressed the item number " + String.valueOf(position+1) + " in GridView";



               Toast.makeText(getApplicationContext(), position_string, Toast.LENGTH_SHORT).show();
            }
        });
    }



    public static int convertDpToPixels(float dp, Context context){
        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                resources.getDisplayMetrics()
        );
    }


    public class ImageAdapter extends BaseAdapter{
        private Context mContext;
        public int getCount() {
            return myImages.length;
        }
        public Object getItem(int position) {
            return myImages[position];
        }
        public long getItemId(int position) {
            return 0;
        }
        public ImageAdapter(Context c) {
            mContext = c;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null){
                imageView = new ImageView(mContext);
                float w = 50;
                float h = 50;
                int width_pixel = convertDpToPixels(w,icon.this);
                int height_pixel = convertDpToPixels(h,icon.this);
                imageView.setLayoutParams(new GridView.LayoutParams(width_pixel, height_pixel));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setPadding(20, 20, 20, 20);
                imageView.setMaxHeight(60);
            }else{
                imageView = (ImageView) convertView;
            }
            imageView.setBackgroundResource(myImages[position]);
            return imageView;
        }


    }



}
