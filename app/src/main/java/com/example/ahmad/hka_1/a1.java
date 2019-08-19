package com.example.ahmad.hka_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class a1 extends AppCompatActivity {


    int REQUEST_CAMERA = 0, SELECT_FILE = 1, CROP_FROM_CAMERA = 2, REQUEST_CAMERA2 = 3, SELECT_FILE2 = 4;
    Uri mImageCaptureUri;
    adapter_item adp;
    int safheid;
    Typeface textfont;
    String namesafhe;
    ImageView imgadd;
    ImageView background;
    int size;
    ImageView img;



    String[] Languages = { "", "", "",
            "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
    // Declaring the Integer Array with resourse Id's of Images for the Spinners
    Integer[] images = { 0, R.drawable.l1, R.drawable.l2,
            R.drawable.l3, R.drawable.l4,R.drawable.l5,R.drawable.l6,R.drawable.l7,R.drawable.l8,R.drawable.l9,R.drawable.l10,
            R.drawable.l11,R.drawable.l12,R.drawable.l3,R.drawable.l14,R.drawable.l15,R.drawable.l16,R.drawable.l17,R.drawable.l18,
            R.drawable.l19,R.drawable.l20,R.drawable.l21,R.drawable.l22,R.drawable.l23,};




    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);

    }




    public void updatebackgroud() {
        database dbb = new database(a1.this);
        SQLiteDatabase mydb = dbb.getWritableDatabase();
        //SQLiteDatabase mydb1 = openOrCreateDatabase("HKA_DataBase", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
        mydb.execSQL("CREATE TABLE IF  NOT EXISTS background" + safheid + " (id INTEGER PRIMARY KEY,pic BLOB);");
        String sql = "select * from background" + safheid;
        Cursor radifha = mydb.rawQuery(sql, null);
        while (radifha.moveToNext()) {
            String img = radifha.getString(1);
            if (img != null) {
                byte[] decodedString = Base64.decode(img, Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                background.setImageBitmap(decodedByte);

            }
        }
    }


    public void updatelistview() {
        adp.clearlist();
        database database = new database(this);
        SQLiteDatabase mydb = database.getWritableDatabase();
        //SQLiteDatabase mydb1 = openOrCreateDatabase("hka1", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
        mydb.execSQL("CREATE TABLE IF  NOT EXISTS DB" + safheid + " (id INTEGER PRIMARY KEY, name TEXT,pic BLOB, ip INTEGER NOT NULL UNIQUE);");
        String sql = "select * from DB" + safheid;
        Cursor radifha = mydb.rawQuery(sql, null);
        while (radifha.moveToNext()) {
            namayande nm = new namayande();
            nm.id = radifha.getInt(0);
            nm.ip = radifha.getInt(3);
            nm.pic = radifha.getString(2);
            nm.name = radifha.getString(1);
            adp.addtolist(nm);
            try {
                byte[] decodestring = Base64.decode(radifha.getString(radifha.getColumnIndex("pic")), Base64.DEFAULT);
                Bitmap decodebyts = BitmapFactory.decodeByteArray(decodestring, 0, decodestring.length);
                imgadd.setImageBitmap(decodebyts);
            } catch (Exception ex) {
            }
        }
        adp.notifyDataSetChanged();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        Toolbar toolbar6 = (Toolbar) findViewById(R.id.toolbar6);
        setSupportActionBar(toolbar6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String languageload = "en";
        Locale locale = new Locale(languageload);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());


        textfont = Typeface.createFromAsset(getAssets(), "fonts/yekan.ttf");
        final SharedPreferences shp = getSharedPreferences("sett", MODE_PRIVATE);
        size = shp.getInt("size", 16);


        final GridView lst = (GridView) findViewById(R.id.gridView2);
        TextView pagename = (TextView) findViewById(R.id.pagename);
        pagename.setTextSize(size);
        pagename.setTypeface(textfont);


        final SharedPreferences txtseting = getSharedPreferences("program codes", MODE_ENABLE_WRITE_AHEAD_LOGGING);
        SharedPreferences.Editor edi = txtseting.edit();
        edi.commit();
        final String phonenumber = txtseting.getString("phone number", null);
        final String code = txtseting.getString("code hmi", null);
        final String avalesms = "*" + code + "*";

        final String IMAGEVIEW_TAG = "The Android Logo";


        Bundle extras = getIntent().getExtras();
        namesafhe = extras.getString("name");
        safheid = extras.getInt("id");
        pagename.setText(namesafhe);


        background = (ImageView) findViewById(R.id.imageView27);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(a1.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.on_off);
                dialog.show();
                Button btnon = (Button) dialog.findViewById(R.id.btnon);
                Button btnoff = (Button) dialog.findViewById(R.id.btnoff);
                TextView txtmsg = (TextView) dialog.findViewById(R.id.txtmsg);
                final namayande nm = (namayande) parent.getAdapter().getItem(position);
                String namesms = nm.name;
                txtmsg.setText(namesms);
                btnon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (phonenumber != null && code != null) {
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(phonenumber, null, "*" + code + "*" + String.valueOf(nm.ip) + "*1*", null, null);
                        } else {
                            Toast.makeText(a1.this, "شماره تلفن یا رمز وارد نشده است.", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                btnoff.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (phonenumber != null && code != null) {
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(phonenumber, null, avalesms + String.valueOf(nm.ip) + "*0*", null, null);
                        } else {
                            Toast.makeText(a1.this, "شماره تلفن یا رمز وارد نشده است.", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
            }
        });


        lst.setTag(IMAGEVIEW_TAG);


        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(a1.this);
                dialog.setCancelable(true);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.editicon);
                Window window = dialog.getWindow();
                window.setGravity(Gravity.TOP);
                dialog.show();
                final namayande nm = (namayande) parent.getAdapter().getItem(position);
                ImageView delete = (ImageView) dialog.findViewById(R.id.imageView20);
                ImageView edit = (ImageView) dialog.findViewById(R.id.imageView21);


                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            SQLiteDatabase mydb = openOrCreateDatabase("HKA_DataBase", Context.MODE_PRIVATE, null);
                            mydb.execSQL("DELETE FROM DB" + safheid + " WHERE name = '" + nm.name + "'");
                            mydb.close();
                            Toast.makeText(getApplicationContext(), "با موفقیت حذف شد.", Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error encountered while deleting.", Toast.LENGTH_LONG).show();
                        }
                        dialog.dismiss();
                        updatelistview();

                    }
                });


                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        final Dialog dialog = new Dialog(a1.this);
                        dialog.setCancelable(true);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.activity_add2);

                        dialog.show();
                        final EditText txtname = (EditText) dialog.findViewById(R.id.editText);
                        final EditText txtip = (EditText) dialog.findViewById(R.id.editText33);
                        Button save = (Button) dialog.findViewById(R.id.button);
                        Button cancel = (Button) dialog.findViewById(R.id.button2);
                        Button txtnamesafhe = (Button) dialog.findViewById(R.id.txtname);
                        Button t1 = (Button) dialog.findViewById(R.id.t1);
                        Button t2 = (Button) dialog.findViewById(R.id.t2);

                        save.setTextSize(size);
                        cancel.setTextSize(size);
                        t1.setTextSize(size);
                        t2.setTextSize(size);
                        txtnamesafhe.setTextSize(size);
                        txtnamesafhe.setText("ویرایش");
                        save.setTypeface(textfont);
                        cancel.setTypeface(textfont);
                        t1.setTypeface(textfont);
                        t2.setTypeface(textfont);
                        txtnamesafhe.setTypeface(textfont);


                        SQLiteDatabase mydb = openOrCreateDatabase("HKA_DataBase", Context.MODE_PRIVATE, null);
                        String sql = "select * from DB" + safheid + " where id = ' " + nm.id + " '";
                        Cursor radifha = mydb.rawQuery(sql, null);
                        while (radifha.moveToNext()) {
                            namayande nm = new namayande();
                            nm.id = radifha.getInt(0);
                            nm.name = radifha.getString(1);
                            nm.pic = radifha.getString(2);
                            nm.ip = radifha.getInt(3);
                            String name = nm.name;
                            String ip = String.valueOf(nm.ip);
                            txtip.setText(ip);
                            txtname.setText(name);
                            adp.addtolist(nm);

                            try {
                                byte[] decodestring = Base64.decode(radifha.getString(radifha.getColumnIndex("pic")), Base64.DEFAULT);
                                Bitmap decodebyts = BitmapFactory.decodeByteArray(decodestring, 0, decodestring.length);
                                imgadd.setImageBitmap(decodebyts);
                            } catch (Exception ex) {
                            }
                        }

                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        imgadd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                selectImage();
                            }
                        });
                        save.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (txtname.getText().toString().length() > 0 && txtip.getText().toString().length() > 0) {
                                    try {

                                        SQLiteDatabase mydb = openOrCreateDatabase("HKA_DataBase", Context.MODE_PRIVATE, null);
                                        mydb.execSQL("UPDATE DB" + safheid + " SET name = '" + txtname.getText().toString() + "' WHERE id = '" + nm.id + "'");
                                        mydb.execSQL("UPDATE DB" + safheid + " SET ip = '" + txtip.getText().toString() + "' WHERE id = '" + nm.id + "'");
                                        if (imgadd != null) {
                                            BitmapDrawable drawable = (BitmapDrawable) imgadd.getDrawable();
                                            Bitmap bitmap1 = drawable.getBitmap();
                                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                                            bitmap1.compress(Bitmap.CompressFormat.PNG, 100, bos);
                                            byte[] bb = bos.toByteArray();
                                            String image = Base64.encodeToString(bb, 0);
                                            mydb.execSQL("UPDATE DB" + safheid + " SET pic = '" + image + "' WHERE id = '" + nm.id + "'");
                                        }
                                        Intent intent = new Intent(a1.this, firstpage.class);
                                        a1.this.startActivity(intent);
                                        mydb.close();
                                        adp.notifyDataSetChanged();
                                    } catch (Exception e) {
                                        Toast.makeText(getApplicationContext(), "Error encountered while deleting.", Toast.LENGTH_LONG).show();
                                    }
                                    Toast.makeText(getApplicationContext(), "saved succesfully", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                    updatelistview();
                                } else {
                                    Toast.makeText(a1.this, "please enter name and ip", Toast.LENGTH_SHORT);
                                }
                                dialog.dismiss();
                                updatelistview();

                            }
                        });
                    }
                });
                return true;
            }
        });


        final database db = new database(a1.this);
        try {
            db.createDataBase();
        } catch (IOException e) {
            throw new Error("unable to creat database");
        }
        db.openDataBase();
        db.close();
        adp = new adapter_item();
        lst.setAdapter(adp);
        updatelistview();
        updatebackgroud();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add) {
            final Dialog dialog = new Dialog(a1.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(true);
            dialog.setTitle("افزودن موارد بیشتر");
            dialog.setContentView(R.layout.activity_add2);
            final EditText txtnam = (EditText) dialog.findViewById(R.id.editText);
            final EditText txtip = (EditText) dialog.findViewById(R.id.editText33);

            Spinner mySpinner = (Spinner) dialog.findViewById(R.id.spinner);
            mySpinner.setAdapter(new MyAdapter(a1.this, R.layout.custom, Languages));

            Button btnsave = (Button) dialog.findViewById(R.id.button);
            Button btncancel = (Button) dialog.findViewById(R.id.button2);

            Button txtnamesafhe = (Button) dialog.findViewById(R.id.txtname);
            Button t1 = (Button) dialog.findViewById(R.id.t1);
            Button t2 = (Button) dialog.findViewById(R.id.t2);

            t1.setTextSize(size);
            t2.setTextSize(size);
            txtnamesafhe.setTextSize(size);
            btncancel.setTextSize(size);
            btnsave.setTextSize(size);
            txtip.setTextSize(size);
            txtnam.setTextSize(size);
            txtip.setTypeface(textfont);
            txtnam.setTypeface(textfont);
            txtnamesafhe.setText("افزودن موارد بیشتر");
            t1.setTypeface(textfont);
            t2.setTypeface(textfont);
            txtnamesafhe.setTypeface(textfont);
            btncancel.setTypeface(textfont);
            btnsave.setTypeface(textfont);



            btnsave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (txtnam.getText().toString().length() > 0 && txtip.getText().toString().length() > 0) {

                        database hlp = new database(a1.this);
                        SQLiteDatabase database = hlp.getWritableDatabase();
                        ContentValues values = new ContentValues();

                        values.put("name", txtnam.getText().toString());
                        values.put("ip", txtip.getText().toString());
                        if (img.getDrawable() != null) {
                            BitmapDrawable drawable = (BitmapDrawable) img.getDrawable();
                            Bitmap bitmap1 = drawable.getBitmap();
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            bitmap1.compress(Bitmap.CompressFormat.PNG, 100, bos);
                            byte[] bb = bos.toByteArray();
                            String image = Base64.encodeToString(bb, 0);
                            values.put("pic", image);
                        }
                        database.insert("DB" + safheid, null, values);
                        database.close();
                        hlp.close();
                        updatelistview();


                        Toast.makeText(a1.this, "با موفقیت ذخیره شد.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    } else {
                        Toast.makeText(a1.this, "please enter name and Ip", Toast.LENGTH_SHORT).show();
                    }
                }


            });
            btncancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        } else if (id == R.id.background) {
            final Dialog dialog = new Dialog(a1.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.activity_add3);
            dialog.show();

            imgadd = (ImageView) dialog.findViewById(R.id.imageView7);
            Button savebtn = (Button) dialog.findViewById(R.id.button1);
            Button btncancel = (Button) dialog.findViewById(R.id.button2);
            Button txtnamesafhe = (Button) dialog.findViewById(R.id.txtname);
            txtnamesafhe.setText("تغییر تصویر زمینه");
            txtnamesafhe.setTextSize(size);
            btncancel.setTextSize(size);
            savebtn.setTextSize(size);
            txtnamesafhe.setTypeface(textfont);
            btncancel.setTypeface(textfont);
            savebtn.setTypeface(textfont);

            imgadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectImage();
                }
            });

            btncancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            savebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    database hlp = new database(a1.this);
                    SQLiteDatabase database = hlp.getWritableDatabase();
                    database.execSQL("CREATE TABLE IF  NOT EXISTS background" + safheid + " (id INTEGER PRIMARY KEY,pic TEXT);");
                    ContentValues values = new ContentValues();

                    if (imgadd.getDrawable() != null) {
                        BitmapDrawable drawable = (BitmapDrawable) imgadd.getDrawable();
                        Bitmap bitmap1 = drawable.getBitmap();
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        bitmap1.compress(Bitmap.CompressFormat.JPEG, 8, bos);
                        byte[] bb = bos.toByteArray();
                        String image = Base64.encodeToString(bb, 0);
                        values.put("pic", image);
                        database.insert("background" + safheid, null, values);
                        database.close();
                        dialog.dismiss();
                        hlp.close();
                    } else {
                        dialog.dismiss();
                    }

                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);

                }
            });


        } else if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
        }
    }



    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Uri selectedImageUri = data.getData();
        String[] projection = { MediaStore.MediaColumns.DATA };
        Cursor cursor = managedQuery(selectedImageUri, projection, null, null,
                null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();

        String selectedImagePath = cursor.getString(column_index);


        Bitmap bm;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, options);
        final int REQUIRED_SIZE = 200;
        int scale = 1;
        while (options.outWidth / scale / 2 <= REQUIRED_SIZE
                && options.outHeight / scale / 2 <= REQUIRED_SIZE)
            scale *= 2;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(selectedImagePath, options);

        imgadd.setImageBitmap(bm);
    }




    public class MyAdapter extends ArrayAdapter {

        public MyAdapter(Context context, int textViewResourceId,
                         String[] objects) {
            super(context, textViewResourceId, objects);
        }

        public View getCustomView(int position, View convertView,
                                  ViewGroup parent) {

// Inflating the layout for the custom Spinner
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom, parent, false);

// Declaring and Typecasting the textview in the inflated layout
            TextView tvLanguage = (TextView) layout
                    .findViewById(R.id.tvLanguage);

// Setting the text using the array
            tvLanguage.setText(Languages[position]);

// Setting the color of the text
            tvLanguage.setTextColor(Color.rgb(75, 180, 225));

// Declaring and Typecasting the imageView in the inflated layout
            img = (ImageView) layout.findViewById(R.id.imgLanguage);

// Setting an image using the id's in the array
            img.setImageResource(images[position]);




// Setting Special atrributes for 1st element
            if (position == 0) {
// Removing the image view
                img.setVisibility(View.GONE);
// Setting the size of the text
                tvLanguage.setTextSize(20f);
// Setting the text Color
                tvLanguage.setTextColor(Color.BLACK);

            }

            return layout;
        }

        // It gets a View that displays in the drop down popup the data at the specified position
        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        // It gets a View that displays the data at the specified position
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }
    }
}










