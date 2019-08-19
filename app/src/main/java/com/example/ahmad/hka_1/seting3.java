package com.example.ahmad.hka_1;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;


public class seting3 extends AppCompatActivity {

    SharedPreferences txtseting;
    String simkart;
    int size;
    Typeface textfont;
    Typeface numfont;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seting3);

        txtseting=getSharedPreferences("program codes",MODE_ENABLE_WRITE_AHEAD_LOGGING);
        final SharedPreferences shp = getSharedPreferences("sett", MODE_PRIVATE);
        size = shp.getInt("size", 16);

        textfont = Typeface.createFromAsset(getAssets(),"fonts/yekan.ttf");
        numfont = Typeface.createFromAsset(getAssets(),"fonts/bgothm.ttf");
        Toolbar toolbar = (Toolbar) findViewById(R.id.tolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final EditText txt_num= (EditText) findViewById(R.id.editText6);
        final EditText txt_code= (EditText) findViewById(R.id.editText9);
        txt_num.setText(txtseting.getString("phone number",null));
        txt_code.setText(txtseting.getString("code hmi", null));
        Button btnfont= (Button) findViewById(R.id.button25);
        final TextView sim= (TextView) findViewById(R.id.textView8);
        TextView ramz= (TextView) findViewById(R.id.textView11);
        TextView er= (TextView) findViewById(R.id.textView12);
        RadioButton r1= (RadioButton) findViewById(R.id.radioButton4);
        RadioButton r2= (RadioButton) findViewById(R.id.radioButton5);
        RadioButton r3= (RadioButton) findViewById(R.id.radioButton6);
        final Button btn_save= (Button) findViewById(R.id.button22);
        Button btn_passchange= (Button) findViewById(R.id.button7);
        TextView pagename= (TextView) findViewById(R.id.pagename);

        pagename.setTextSize(size);
        r2.setChecked(true);
        sim.setTextSize(size);
        ramz.setTextSize(size);
        er.setTextSize(size);
        btnfont.setTextSize(size);
        r1.setTextSize(size);
        r2.setTextSize(size);
        r3.setTextSize(size);
        btn_passchange.setTextSize(size);
        btn_save.setTextSize(size);

        pagename.setTypeface(textfont);
        sim.setTypeface(textfont);
        ramz.setTypeface(textfont);
        er.setTypeface(textfont);
        btnfont.setTypeface(textfont);
        r1.setTypeface(textfont);
        r2.setTypeface(textfont);
        r3.setTypeface(textfont);
        btn_passchange.setTypeface(textfont);
        btn_save.setTypeface(textfont);
        txt_code.setTypeface(textfont);
        txt_num.setTypeface(textfont);




        final Animation animtranslate = AnimationUtils.loadAnimation(this, R.anim.anim_button);

        String languageload="en";
        Locale locale=new Locale(languageload);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        btnfont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog2 = new Dialog(seting3.this);
                dialog2.setCancelable(true);
                dialog2.onBackPressed();
                dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog2.setContentView(R.layout.fontsize);
                dialog2.show();

                final Button save = (Button) dialog2.findViewById(R.id.btnSave0);
                final Button cance1 = (Button) dialog2.findViewById(R.id.btnscancel0);
                final SeekBar skb = (SeekBar) dialog2.findViewById(R.id.seekBar1);
                final TextView changefont = (TextView) dialog2.findViewById(R.id.textView0);
                final Button txtnamesafhe = (Button) dialog2.findViewById(R.id.txtname);

                txtnamesafhe.setTypeface(textfont);
                save.setTypeface(textfont);
                cance1.setTypeface(textfont);

                final SharedPreferences shp = getSharedPreferences("sett", MODE_PRIVATE);
                int aa = shp.getInt("size", 16);

                txtnamesafhe.setTextSize(aa);
                changefont.setTextSize(aa);
                cance1.setTextSize(aa);
                save.setTextSize(aa);
                skb.setMax(40);
                skb.setProgress(aa);
                skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onStopTrackingTouch(SeekBar arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                        // TODO Auto-generated method stub
                        changefont.setTextSize(arg1);
                        size = arg1;
                    }
                });


                cance1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });

                save.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        SharedPreferences.Editor shpE = shp.edit();
                        shpE.putInt("size", size);
                        shpE.commit();
                        Intent intent=new Intent(seting3.this,seting3.class);
                        seting3.this.startActivity(intent);
                        finish();
                        dialog2.dismiss();// /safhe Setting ro mibande
                    }
                });
            }
        });




        btn_passchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(seting3.this);
                dialog.setCancelable(true);
                dialog.setTitle("تغییر رمز عبور");
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_change_pass);
                dialog.show();
                v.startAnimation(animtranslate);
                final EditText txtoldpass= (EditText) dialog.findViewById(R.id.editText3);
                final EditText txtnewpass= (EditText) dialog.findViewById(R.id.editText2);
                final EditText txtnewpass2= (EditText) dialog.findViewById(R.id.editText4);
                Button btnsave= (Button) dialog.findViewById(R.id.button4);
                Button btnback= (Button) dialog.findViewById(R.id.button3);
                TextView txtnamesafhe= (TextView) dialog.findViewById(R.id.txtname);
                final CheckBox checkBox= (CheckBox) dialog.findViewById(R.id.checkBox);
                txtnamesafhe.setText("تغییر رمز عبور");

                int aa=txtseting.getInt("password cancel",0);
                if (aa==1){
                    checkBox.setChecked(true);
                }

                btnsave.setTypeface(textfont);
                txtnamesafhe.setTypeface(textfont);
                btnback.setTypeface(textfont);
                txtoldpass.setTypeface(textfont);
                txtnewpass.setTypeface(textfont);
                txtnewpass2.setTypeface(textfont);
                checkBox.setTypeface(textfont);
                btnsave.setTextSize(size);
                checkBox.setTextSize(size);
                txtnamesafhe.setTextSize(size);
                btnback.setTextSize(size);
                txtoldpass.setTextSize(size);
                txtnewpass.setTextSize(size);
                txtnewpass2.setTextSize(size);
                btnback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        v.startAnimation(animtranslate);
                    }
                });

                btnsave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor edi = txtseting.edit();
                        String oldpass = txtoldpass.getText().toString();
                        String newpass = txtnewpass.getText().toString();
                        String newpass2 = txtnewpass2.getText().toString();
                        v.startAnimation(animtranslate);


                        if (checkBox.isChecked())
                        {
                            edi.putInt("password cancel", 1);
                            edi.commit();
                            dialog.dismiss();
                        }
                        else
                        {
                            edi.putInt("password cancel", 0);
                            edi.commit();
                            if (txtseting.getString("password", null).equals(oldpass)) {
                                if (newpass.equals(newpass2)) {
                                    edi.putInt("password cancel", 0);
                                    edi.putString("password", newpass);
                                    edi.commit();
                                    Toast.makeText(seting3.this,"رمز ورود جدید شما :"+txtseting.getString("password", null), Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                } else {
                                    Toast.makeText(seting3.this, "رمزها مطابقت ندارد.", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(seting3.this, "رمز اشتباه می باشد.", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                });
            }

    });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number=txt_num.getText().toString();
                String code=txt_code.getText().toString();
                v.startAnimation(animtranslate);
                SharedPreferences.Editor edi=txtseting.edit();
                edi.putString("phone number",number);
                edi.putString("code hmi", code);
                edi.putString("simkart", simkart);
                edi.commit();
                Toast.makeText(seting3.this,"ذخیره شد.",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id==android.R.id.home){
            Intent intent=new Intent(seting3.this,firstpage.class);
            seting3.this.startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
