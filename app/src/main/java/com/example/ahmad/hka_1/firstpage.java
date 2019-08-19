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
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class firstpage extends AppCompatActivity {


    public static File sdCardDirectory;
    public static SQLiteDatabase database;
    String imagename;
    String Imagepath;
    EditText edt;

    ImageView imgadd=null;
    EditText txt1;
    Button btnsave;
    Button btnback;
    adapter_item adp;
    int REQUEST_CAMERA = 0, SELECT_FILE = 1,CROP_FROM_CAMERA = 2,REQUEST_CAMERA2= 3, SELECT_FILE2 = 4;
    Uri mImageCaptureUri;
    int size;
    Typeface textfont;



/*

    void showPopupWindow(View view) {
        PopupMenu popup = new PopupMenu(firstpage.this, view);
        try {
            Field[] fields = popup.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popup);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(getApplicationContext(), "You Clicked : " + item.getTitle(),  Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popup.show();
    }



*/



    public void  updatelistview() {
        adp.clearlist();
        database db1 = new database(firstpage.this);
        SQLiteDatabase database1 = db1.getWritableDatabase();
        database1.execSQL("CREATE TABLE IF  NOT EXISTS hka (id INTEGER PRIMARY KEY, name TEXT, pic TEXT);");
        String sql = "select * from hka";
            Cursor radifha = database1.rawQuery(sql, null);
            while (radifha.moveToNext()) {
                namayande mn = new namayande();
                mn.id = radifha.getInt(0);
                mn.name = radifha.getString(1);
                mn.pic = radifha.getString(2);
                adp.addtolist(mn);
            }
            adp.notifyDataSetChanged();
    }







    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);


        Toolbar toolbar = (Toolbar) findViewById(R.id.view);
        setSupportActionBar(toolbar);

        final ImageView background= (ImageView) findViewById(R.id.imgbackgroung);

        final SharedPreferences shp = getSharedPreferences("sett", MODE_PRIVATE);
        size = shp.getInt("size", 16);

                database dbb=new database(firstpage.this);
                SQLiteDatabase mydb=dbb.getWritableDatabase();
                //SQLiteDatabase mydb1 = openOrCreateDatabase("HKA_DataBase", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
                mydb.execSQL("CREATE TABLE IF  NOT EXISTS background (id INTEGER PRIMARY KEY,pic BLOB);");
                String sql="select * from background";
                Cursor radifha=mydb.rawQuery(sql,null);
                while (radifha.moveToNext()) {
                    String img = radifha.getString(1);

                        byte[] decodedString = Base64.decode(img, Base64.DEFAULT);
                        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                        background.setImageBitmap(decodedByte);

                }






        sdCardDirectory = new File(Environment.getExternalStorageDirectory(),
                "/.ImageDB/");

       // iv = (ImageView) findViewById(R.id.imageView1);
       // Button add = (Button) findViewById(R.id.button1);
        //edt = (EditText) findViewById(R.id.editText1);

        String path = Environment.getDataDirectory() + "/data/"
                + getPackageName() + "/content.db";

        database = SQLiteDatabase.openDatabase(path, null,
                SQLiteDatabase.CREATE_IF_NECESSARY);



/*


        final int[] mSongs = new int[] { R.raw.l1, R.raw.l2,  R.raw.l3, R.raw.l4, R.raw.l5, R.raw.l6,
                R.raw.l7, R.raw.l8, R.raw.l9, R.raw.l10, R.raw.l11, R.raw.l12, R.raw.l13 ,R.raw.l14,
                R.raw.l15, R.raw.l16, R.raw.l17, R.raw.l18, R.raw.l19, R.raw.l20, R.raw.l21, R.raw.l22, R.raw.l23};
        for (int i = 0; i < mSongs.length; i++) {
            try {
                String path = Environment.getExternalStorageDirectory() + "/hka/logo";
                File dir = new File(path);
                if (dir.mkdirs() || dir.isDirectory()) {
                    String str_song_name = i + ".jpg";
                    CopyRAWtoSDCard(mSongs[i], path + File.separator + str_song_name);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void CopyRAWtoSDCard(int id, String path) throws IOException {
        InputStream in = getResources().openRawResource(id);
        FileOutputStream out = new FileOutputStream(path);
        byte[] buff = new byte[1024];
        int read = 0;
        try {
            while ((read = in.read(buff)) > 0) {
                out.write(buff, 0, read);
            }
        } finally {
            in.close();
            out.close();
        }


*/





        String languageload="en";
        Locale locale=new Locale(languageload);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());


        textfont = Typeface.createFromAsset(getAssets(),"fonts/yekan.ttf");
        final ImageView img_add = (ImageView) findViewById(R.id.imageView2);
        final ImageView img_senario = (ImageView) findViewById(R.id.imageView3);
        final ImageView img_seting = (ImageView) findViewById(R.id.imageView4);
        final ImageView img_suport = (ImageView) findViewById(R.id.imageView5);
        TextView pagename= (TextView) findViewById(R.id.pagename);
        pagename.setTextSize(size);
        pagename.setTypeface(textfont);
        final Animation animtranslate = AnimationUtils.loadAnimation(this, R.anim.anim_button);
        TextView add= (TextView) findViewById(R.id.textView23);
        TextView setting= (TextView) findViewById(R.id.textView26);
        TextView senario= (TextView) findViewById(R.id.textView28);
        TextView support= (TextView) findViewById(R.id.textView27);

        add.setTypeface(textfont);
        setting.setTypeface(textfont);
        senario.setTypeface(textfont);
        support.setTypeface(textfont);

        add.setTextSize(size);
        setting.setTextSize(size);
        senario.setTextSize(size);
        support.setTextSize(size);



        final database db = new database(firstpage.this);

        try {
            db.createDataBase();
        } catch (IOException e) {
            throw  new Error("unable to creat database");
        }

        db.openDataBase();
        db.close();
        final GridView lst = (GridView) findViewById(R.id.gridView);

        adp=new adapter_item();
        lst.setAdapter(adp);
        updatelistview();



        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(firstpage.this, a1.class);
                namayande nm = (namayande) parent.getAdapter().getItem(position);
                String pagename = nm.name;
                int pageid = nm.id;
                intent.putExtra("name", pagename);
                intent.putExtra("id", pageid);
                overridePendingTransition(R.anim.pageanim,R.anim.pageanim2);
                //Toast.makeText(firstpage.this,nm.name+String.valueOf(nm.id),Toast.LENGTH_SHORT).show();
                //Toast.makeText(firstpage.this, pagename.toString(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });




        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final Dialog dialog=new Dialog(firstpage.this);
                dialog.setCancelable(true);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.editicon);
                Window window=dialog.getWindow();
                window.setGravity(Gravity.TOP);
                dialog.show();
                final namayande nm = (namayande) parent.getAdapter().getItem(position);
                ImageView delete= (ImageView) dialog.findViewById(R.id.imageView20);
                ImageView edit= (ImageView) dialog.findViewById(R.id.imageView21);


                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            SQLiteDatabase mydb = openOrCreateDatabase("HKA_DataBase", Context.MODE_PRIVATE, null);
                            mydb.execSQL("DELETE FROM hka WHERE id = '" + nm.id + "'");
                            mydb.close();
                            //Toast.makeText(getApplicationContext(), "با موفقیت حذف شد.", Toast.LENGTH_LONG).show();

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
                        final Dialog dialog=new Dialog(firstpage.this);
                        dialog.setCancelable(true);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.activity_add1);
                        dialog.show();
                        txt1 = (EditText) dialog.findViewById(R.id.editText);
                        btnsave = (Button) dialog.findViewById(R.id.button);
                        imgadd = (ImageView) dialog.findViewById(R.id.imageView7);
                        btnback = (Button) dialog.findViewById(R.id.button2);
                        Button txtnamesafhe= (Button) dialog.findViewById(R.id.txtname);

                        txtnamesafhe.setText("ویرایش");
                        txtnamesafhe.setTextSize(size);
                        btnsave.setTextSize(size);
                        btnback.setTextSize(size);
                        txtnamesafhe.setTypeface(textfont);
                        btnsave.setTypeface(textfont);
                        btnback.setTypeface(textfont);

                        SQLiteDatabase mydb = openOrCreateDatabase("HKA_DataBase", Context.MODE_PRIVATE, null);
                        String sql="select * from hka where id = ' "+nm.id+" '";
                        Cursor radifha=mydb.rawQuery(sql, null);
                        while (radifha.moveToNext())
                        {
                            namayande nm=new namayande();
                            nm.id=radifha.getInt(0);
                            nm.name=radifha.getString(1);
                            nm.pic=radifha.getString(2);
                            String name=nm.name;
                            txt1.setText(name);
                            adp.addtolist(nm);
                            try {
                                byte[] decodestring = Base64.decode(radifha.getString(radifha.getColumnIndex("pic")), Base64.DEFAULT);
                                Bitmap decodebyts = BitmapFactory.decodeByteArray(decodestring, 0, decodestring.length);
                                imgadd.setImageBitmap(decodebyts);
                            }catch (Exception ex){}
                        }


                        imgadd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                v.startAnimation(animtranslate);
                                selectImage();

                            }
                        });

                        btnback.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        btnsave.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                    SQLiteDatabase mydb = openOrCreateDatabase("HKA_DataBase", Context.MODE_PRIVATE, null);
                                    mydb.execSQL("UPDATE hka SET name = '" + txt1.getText().toString() + "' WHERE id = '" + nm.id + "'");
                                    if (imgadd != null){
                                        BitmapDrawable drawable = (BitmapDrawable) imgadd.getDrawable();
                                        Bitmap bitmap1 = drawable.getBitmap();
                                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                                        bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                                        byte[] bb = bos.toByteArray();
                                        String image = Base64.encodeToString(bb, 0);
                                        mydb.execSQL("UPDATE hka SET pic = '" + image + "' WHERE id = '" + nm.id + "'");}
                                     /*
                                    Intent intent=new Intent(firstpage.this,firstpage.class);
                                    firstpage.this.startActivity(intent);
                                    */
                                    mydb.close();
                                    adp.notifyDataSetChanged();

                                } catch (Exception e) {

                                }dialog.dismiss()
                                ;updatelistview();
                            }
                        });

                    }
                });

                return true;
            }
        });







        img_suport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten_support = new Intent(firstpage.this, suport.class);
                startActivity(inten_support);
                overridePendingTransition(R.anim.pageanim,R.anim.pageanim2);
                v.startAnimation(animtranslate);
            }
        });




        img_seting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_seting = new Intent(firstpage.this, seting3.class);
                startActivity(intent_seting);
                finish();
                overridePendingTransition(R.anim.pageanim,R.anim.pageanim2);
                v.startAnimation(animtranslate);
            }
        });




        img_senario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_senario = new Intent(firstpage.this, senario3.class);
                startActivity(intent_senario);
                overridePendingTransition(R.anim.pageanim,R.anim.pageanim2);
                v.startAnimation(animtranslate);
            }
        });



        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animtranslate);
                final Dialog dialog = new Dialog(firstpage.this);
                dialog.setCancelable(true);
                dialog.setTitle("افزودن صفحه جدید");
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_add1);
                dialog.show();
                txt1 = (EditText) dialog.findViewById(R.id.editText);
                btnsave = (Button) dialog.findViewById(R.id.button);
                imgadd = (ImageView) dialog.findViewById(R.id.imageView7);
                btnback = (Button) dialog.findViewById(R.id.button2);
                Button bt= (Button) dialog.findViewById(R.id.textView5);

                Button txtnamesafhe= (Button) dialog.findViewById(R.id.txtname);
                txtnamesafhe.setText("افزودن صفحه جدید");

                txtnamesafhe.setTextSize(size);
                btnsave.setTextSize(size);
                btnback.setTextSize(size);
                bt.setTextSize(size);
                txt1.setTextSize(size);
                txtnamesafhe.setTypeface(textfont);
                btnsave.setTypeface(textfont);
                btnback.setTypeface(textfont);
                bt.setTypeface(textfont);
                txt1.setTypeface(textfont);


                imgadd.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       selectImage();
                   }
               });

                btnsave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (txt1.getText().toString().length()>0) {
                            database hlp = new database(firstpage.this);
                            SQLiteDatabase database = hlp.getWritableDatabase();
                            ContentValues values = new ContentValues();
                            values.put("name", txt1.getText().toString());

                            if (imgadd.getDrawable() !=null)
                            {
                            BitmapDrawable drawable = (BitmapDrawable) imgadd.getDrawable();
                            Bitmap bitmap1 = drawable.getBitmap();
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            bitmap1.compress(Bitmap.CompressFormat.JPEG, 3, bos);
                            byte[] bb = bos.toByteArray();
                            String image = Base64.encodeToString(bb, 0);
                            values.put("pic", image);
                            }

                            database.insert("hka", null, values);
                            database.close();
                            hlp.close();
                            dialog.dismiss();
                            updatelistview();
                            Intent intent=new Intent(firstpage.this,firstpage.class);
                            firstpage.this.startActivity(intent);
                            finish();
                            Toast.makeText(getApplicationContext(), "ذخیره شد", Toast.LENGTH_SHORT).show();
                        }else {Toast.makeText(firstpage.this,"لطفا یک نام وارد کنید.",Toast.LENGTH_SHORT);}
                    }
                });

                btnback.setOnClickListener(new View.OnClickListener()

                                           {
                                               @Override
                                               public void onClick(View v) {
                                                   dialog.dismiss();
                                               }
                                           }
                );
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.background) {

            final Dialog dialog2 = new Dialog(firstpage.this);
            dialog2.setCancelable(true);
            dialog2.setTitle("تغییر تصویر زمینه");
            dialog2.onBackPressed();
            dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog2.setContentView(R.layout.activity_add4);
            dialog2.show();

            imgadd = (ImageView) dialog2.findViewById(R.id.imageView7000);
            Button btnsave = (Button) dialog2.findViewById(R.id.button1000);
            Button btnback = (Button) dialog2.findViewById(R.id.button2000);
            Button txtnamesafhe = (Button) dialog2.findViewById(R.id.txtname);
            TextView adddd = (TextView) dialog2.findViewById(R.id.textView45);

            txtnamesafhe.setTextSize(size);
            btnsave.setTextSize(size);
            btnback.setTextSize(size);
            txtnamesafhe.setText("تغییر تصویر زمینه");
            txtnamesafhe.setTypeface(textfont);
            btnsave.setTypeface(textfont);
            btnback.setTypeface(textfont);

            btnback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog2.dismiss();
                }
            });



            adddd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectImage();
                }
            });
            imgadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectImage();
                }
            });

            btnsave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    database hlp = new database(firstpage.this);
                    SQLiteDatabase database = hlp.getWritableDatabase();
                    database.execSQL("CREATE TABLE IF  NOT EXISTS background (id INTEGER PRIMARY KEY,pic TEXT);");
                    ContentValues values = new ContentValues();
                    if (imgadd.getDrawable() != null){
                        BitmapDrawable drawable = (BitmapDrawable) imgadd.getDrawable();
                        Bitmap bitmap1 = drawable.getBitmap();
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        bitmap1.compress(Bitmap.CompressFormat.JPEG, 8, bos);
                        byte[] bb = bos.toByteArray();
                        String image = Base64.encodeToString(bb, 0);
                        values.put("pic", image);
                        database.insert("background", null, values);
                        database.close();
                        dialog2.dismiss();
                        hlp.close();
                        Intent intent=new Intent(firstpage.this,firstpage.class);
                        firstpage.this.startActivity(intent);
                        finish();
                    }

                    else {dialog2.dismiss();}
                }
            });

            return true;
        }

        return super.onOptionsItemSelected(item);


    }



/*

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "برای خروج از برنامه بروی دکمه خروج  دوباره کنید!", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }

*/



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
        final int REQUIRED_SIZE = 100;
        int scale = 1;
        while (options.outWidth / scale / 2 <= REQUIRED_SIZE
                && options.outHeight / scale / 2 <= REQUIRED_SIZE)
            scale *= 2;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(selectedImagePath, options);

        imgadd.setImageBitmap(bm);
    }

}
