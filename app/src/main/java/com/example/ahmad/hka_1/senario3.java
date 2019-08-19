package com.example.ahmad.hka_1;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class senario3 extends AppCompatActivity {


    String btnid;
    String phonenumber;
    String code;
    String code2;
    String avalesms;
    String btnname;
    int size;
    Typeface textfont;






    public void codesenario(){
        final Dialog dialog=new Dialog(senario3.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.codesenario);
        dialog.show();

        final SharedPreferences shp = getSharedPreferences("sett", MODE_PRIVATE);
        size = shp.getInt("size", 16);

        final EditText code1= (EditText) dialog.findViewById(R.id.code1);
        final EditText code2= (EditText) dialog.findViewById(R.id.code2);
        final EditText code3= (EditText) dialog.findViewById(R.id.code3);
        final EditText code4= (EditText) dialog.findViewById(R.id.code4);
        final EditText code5= (EditText) dialog.findViewById(R.id.code5);
        final EditText code6= (EditText) dialog.findViewById(R.id.code6);
        final EditText code7= (EditText) dialog.findViewById(R.id.code7);
        final EditText code8= (EditText) dialog.findViewById(R.id.code8);
        final EditText code9 = (EditText) dialog.findViewById(R.id.code9);
        final EditText code10 = (EditText) dialog.findViewById(R.id.code10);
        final EditText code11 = (EditText) dialog.findViewById(R.id.code11);
        final EditText code12 = (EditText) dialog.findViewById(R.id.code12);
        final EditText code13= (EditText) dialog.findViewById(R.id.code13);
        TextView txt1= (TextView) dialog.findViewById(R.id.textView7);
        TextView txt2= (TextView) dialog.findViewById(R.id.textView9);
        TextView txt3= (TextView) dialog.findViewById(R.id.textView10);
        TextView txt4= (TextView) dialog.findViewById(R.id.textView13);
        TextView txt5= (TextView) dialog.findViewById(R.id.textView14);
        TextView txt6= (TextView) dialog.findViewById(R.id.textView15);
        TextView txt7= (TextView) dialog.findViewById(R.id.textView16);
        TextView txt8= (TextView) dialog.findViewById(R.id.textView17);
        TextView txt9= (TextView) dialog.findViewById(R.id.textView18);
        TextView txt10= (TextView) dialog.findViewById(R.id.textView19);
        TextView txt11= (TextView) dialog.findViewById(R.id.textView20);
        TextView txt12= (TextView) dialog.findViewById(R.id.textView21);
        TextView txt13= (TextView) dialog.findViewById(R.id.textView22);
        TextView txxtname= (TextView) dialog.findViewById(R.id.txtname);



        Button cancel= (Button) dialog.findViewById(R.id.button2);
        Button save= (Button) dialog.findViewById(R.id.button1);

        SharedPreferences codesenario=getSharedPreferences("codesenario", MODE_PRIVATE);
        final SharedPreferences.Editor edi = codesenario.edit();

        code1.setText(codesenario.getString("code1", null));
        code2.setText(codesenario.getString("code2", null));
        code3.setText(codesenario.getString("code3", null));
        code4.setText(codesenario.getString("code4", null));
        code5.setText(codesenario.getString("code5", null));
        code6.setText(codesenario.getString("code6", null));
        code7.setText(codesenario.getString("code7", null));
        code8.setText(codesenario.getString("code8", null));
        code9.setText(codesenario.getString("code9", null));
        code10.setText(codesenario.getString("code10", null));
        code11.setText(codesenario.getString("code11", null));
        code12.setText(codesenario.getString("code12", null));
        code13.setText(codesenario.getString("code13", null));
        txt1.setTextSize(size);
        txt2.setTextSize(size);
        txt3.setTextSize(size);
        txt4.setTextSize(size);
        txt5.setTextSize(size);
        txt6.setTextSize(size);
        txt7.setTextSize(size);
        txt8.setTextSize(size);
        txt9.setTextSize(size);
        txt10.setTextSize(size);
        txt11.setTextSize(size);
        txt12.setTextSize(size);
        txt13.setTextSize(size);
        code1.setTextSize(size);
        code2.setTextSize(size);
        code3.setTextSize(size);
        code4.setTextSize(size);
        code5.setTextSize(size);
        code6.setTextSize(size);
        code7.setTextSize(size);
        code8.setTextSize(size);
        code9.setTextSize(size);
        code10.setTextSize(size);
        code11.setTextSize(size);
        code12.setTextSize(size);
        code13.setTextSize(size);
        save.setTextSize(size);
        cancel.setTextSize(size);
        txxtname.setTextSize(size);
        txt1.setTypeface(textfont);
        txt2.setTypeface(textfont);
        txt3.setTypeface(textfont);
        txt4.setTypeface(textfont);
        txt5.setTypeface(textfont);
        txt6.setTypeface(textfont);
        txt7.setTypeface(textfont);
        txt8.setTypeface(textfont);
        txt9.setTypeface(textfont);
        txt10.setTypeface(textfont);
        txt11.setTypeface(textfont);
        txt12.setTypeface(textfont);
        txt13.setTypeface(textfont);
        code1.setTypeface(textfont);
        code2.setTypeface(textfont);
        code3.setTypeface(textfont);
        code4.setTypeface(textfont);
        code5.setTypeface(textfont);
        code6.setTypeface(textfont);
        code7.setTypeface(textfont);
        code8.setTypeface(textfont);
        code9.setTypeface(textfont);
        code10.setTypeface(textfont);
        code11.setTypeface(textfont);
        code12.setTypeface(textfont);
        code13.setTypeface(textfont);
        save.setTypeface(textfont);
        cancel.setTypeface(textfont);
        txxtname.setTypeface(textfont);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edi.putString("code1",code1.getText().toString());
                edi.putString("code2",code2.getText().toString());
                edi.putString("code3",code3.getText().toString());
                edi.putString("code4",code4.getText().toString());
                edi.putString("code5",code5.getText().toString());
                edi.putString("code6",code6.getText().toString());
                edi.putString("code7",code7.getText().toString());
                edi.putString("code8",code8.getText().toString());
                edi.putString("code9",code9.getText().toString());
                edi.putString("code10",code10.getText().toString());
                edi.putString("code11",code11.getText().toString());
                edi.putString("code12",code12.getText().toString());
                edi.putString("code13",code13.getText().toString());
                edi.commit();
                dialog.dismiss();
                    /*
                    database hlp = new database(senario3.this);
                    SQLiteDatabase database = hlp.getWritableDatabase();

                    database.execSQL("insert into senario ( code_a ) values ('"+code1.getText().toString()+"');");
                    database.close();
                    hlp.close();
                    dialog.dismiss();
                    */
            }
        });

    }





    public void smscheck(){
        if (code2.length() > 0 & code2 != "0") {
        {
            if (phonenumber != null & code != null) {
                sendsms();
            } else {
                Toast.makeText(senario3.this, "شماره تلفن یا رمز وارد نشده است.", Toast.LENGTH_SHORT).show();
            }
        }
    }else { Toast.makeText(senario3.this, "کد سناریو وارد نشده است.", Toast.LENGTH_SHORT).show();}
    }




    public void sendsms() {
        final Dialog dialog = new Dialog(senario3.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.on_off);
        dialog.show();
        Button btnon = (Button) dialog.findViewById(R.id.btnon);
        Button btnoff = (Button) dialog.findViewById(R.id.btnoff);
        TextView txtmsg = (TextView) dialog.findViewById(R.id.txtmsg);
        txtmsg.setText(btnname);

        btnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                if (phonenumber != null && code != null && phonenumber.length()>0 && code.length()>0) {
                    smsManager.sendTextMessage(phonenumber, null, avalesms + code2 + "*1*", null, null);
                } else {
                    Toast.makeText(senario3.this, "شماره تلفن یا رمز وارد نشده است.", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        });
        btnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();

                if (phonenumber != null && code != null && phonenumber.length()>0 && code.length()>0) {
                    smsManager.sendTextMessage(phonenumber, null, avalesms + code2 + "*0*", null, null);
                } else {
                    Toast.makeText(senario3.this, "شماره تلفن یا رمز وارد نشده است.", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        });
    }









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senario3);

        final SharedPreferences firstrun=getSharedPreferences("first_time_run", MODE_PRIVATE);
        final int firstinstal=firstrun.getInt("instal-senario", 0);
        if (firstinstal==0) {
            codesenario();
            final SharedPreferences.Editor edi1 = firstrun.edit();
            edi1.putInt("instal-senario", 1);
            edi1.commit();
        }




        String languageload = "en";
        Locale locale = new Locale(languageload);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());


        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //final Animation animtranslate = AnimationUtils.loadAnimation(this, R.anim.anim_button);

        textfont = Typeface.createFromAsset(getAssets(),"fonts/yekan.ttf");
        final SharedPreferences txtseting = getSharedPreferences("program codes", MODE_ENABLE_WRITE_AHEAD_LOGGING);
        SharedPreferences.Editor edi = txtseting.edit();
        //edi.putString("phone number", getIntent().getStringExtra("phone number"));
        edi.commit();

        phonenumber = txtseting.getString("phone number", null);
        code = txtseting.getString("code hmi", null);
        avalesms = "*" + code + "*";



        final SharedPreferences shp = getSharedPreferences("sett", MODE_PRIVATE);
        size = shp.getInt("size", 16);

        ImageView img = (ImageView) findViewById(R.id.image1);
        final ImageView img1 = (ImageView) findViewById(R.id.imageView13);
        ImageView img2 = (ImageView) findViewById(R.id.imageView14);
        ImageView img3 = (ImageView) findViewById(R.id.imageView15);
        ImageView img4 = (ImageView) findViewById(R.id.imageView16);
        ImageView img5 = (ImageView) findViewById(R.id.imageView17);
        ImageView img6 = (ImageView) findViewById(R.id.imageView201);
        ImageView img7 = (ImageView) findViewById(R.id.imageView6);
        ImageView img8 = (ImageView) findViewById(R.id.imageView8);
        ImageView img9 = (ImageView) findViewById(R.id.imageView9);
        ImageView img10 = (ImageView) findViewById(R.id.imageView11);
        ImageView img11 = (ImageView) findViewById(R.id.imageView12);
        ImageView img12 = (ImageView) findViewById(R.id.imageView19);

        TextView pagename= (TextView) findViewById(R.id.pagename);
        pagename.setTypeface(textfont);
        pagename.setTextSize(size);


        final SharedPreferences codesenario=getSharedPreferences("codesenario", MODE_ENABLE_WRITE_AHEAD_LOGGING);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                code2 = codesenario.getString("code1", "0");
                btnname = "اعلام حریق";
                smscheck();
            }
        });


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2=codesenario.getString("code2","0");
                btnname = "هشدار با تلفن";

                smscheck();
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2=codesenario.getString("code3","0");
                btnname = "هشدار با پیامک";
                smscheck();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2=codesenario.getString("code4","0");
                btnname = "دوربین و dvr";
                smscheck();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2=codesenario.getString("code5","0");
                btnname = "اعلام نشت گاز";
                smscheck();
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2=codesenario.getString("code6","0");
                btnname = "سناریو 1";
                smscheck();
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2=codesenario.getString("code7","0");
                btnname = "اعلام سرقت";
                smscheck();
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2=codesenario.getString("code8","0");
                btnname = "عدم حضور";
                smscheck();
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2=codesenario.getString("code9","0");
                btnname = "حضور مجازی";
                smscheck();
            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2=codesenario.getString("code10","0");
                btnname = "تنها در خانه";
                smscheck();
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2 = codesenario.getString("code11", "0");
                btnname = "آژیر خطر";
                smscheck();
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2=codesenario.getString("code12","0");
                btnname="قفل آسانسور";
                smscheck();
            }
        });
       img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2=codesenario.getString("code13","0");
                btnname="سناریو 2";
                smscheck();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==android.R.id.home){

            finish();}
        if (id == R.id.code) {
            codesenario();
        }
        return super.onOptionsItemSelected(item);
    }
}