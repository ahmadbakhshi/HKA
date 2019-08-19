package com.example.ahmad.hka_1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class login extends AppCompatActivity {

    Typeface textfont,numfont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





        final EditText txt_pass= (EditText) findViewById(R.id.txtpass);
        final Button btn_enter= (Button) findViewById(R.id.button21);
        final SharedPreferences firstrun=getSharedPreferences("first_time_run", MODE_PRIVATE);
        final int firstinstal=firstrun.getInt("instal", 0);
        final Button btn1= (Button) findViewById(R.id.button5);
        final Button btn2= (Button) findViewById(R.id.button6);
        final Button btn3= (Button) findViewById(R.id.button11);
        final Button btn4= (Button) findViewById(R.id.button12);
        final Button btn5= (Button) findViewById(R.id.button13);
        final Button btn6= (Button) findViewById(R.id.button14);
        final Button btn7= (Button) findViewById(R.id.button15);
        final Button btn8= (Button) findViewById(R.id.button16);
        final Button btn9= (Button) findViewById(R.id.button17);
        final Button btn0= (Button) findViewById(R.id.button19);
        final Button btnbp= (Button) findViewById(R.id.button20);
        final Button btn17= (Button) findViewById(R.id.button7);
        final Animation animtranslate= AnimationUtils.loadAnimation(this, R.anim.num_anim);
        textfont = Typeface.createFromAsset(getAssets(),"fonts/yekan.ttf");
        numfont = Typeface.createFromAsset(getAssets(),"fonts/bgothm.ttf");

        String languageload="en";
        Locale locale=new Locale(languageload);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        btnbp.setTypeface(textfont);
        btn0.setTypeface(textfont);
        btn9.setTypeface(textfont);
        btn8.setTypeface(textfont);
        btn7.setTypeface(textfont);
        btn6.setTypeface(textfont);
        btn5.setTypeface(textfont);
        btn4.setTypeface(textfont);
        btn3.setTypeface(textfont);
        btn2.setTypeface(textfont);
        btn1.setTypeface(textfont);
        btn_enter.setTypeface(textfont);


        if (firstinstal==0)
        {
            final SharedPreferences.Editor edi=firstrun.edit();
            edi.putInt("instal", 1);
            edi.commit();
            //Toast.makeText(getApplicationContext(),"شما برای اولین بار وارد شده اید.لطفا پسورد خود را به دلخواه انتخاب کنید.",Toast.LENGTH_LONG).show();
            showCustomAlert();
        }



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_pass.append("1");
                v.startAnimation(animtranslate);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animtranslate);
                txt_pass.append("2");


            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_pass.append("3");
                v.startAnimation(animtranslate);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_pass.append("4");
                v.startAnimation(animtranslate);

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_pass.append("5");
                v.startAnimation(animtranslate);

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_pass.append("6");
                v.startAnimation(animtranslate);

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_pass.append("7");
                v.startAnimation(animtranslate);

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_pass.append("8");
                v.startAnimation(animtranslate);

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_pass.append("9");
                v.startAnimation(animtranslate);

            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_pass.append("0");
                v.startAnimation(animtranslate);

            }
        });

        btnbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnbp.setTypeface(numfont);
                v.startAnimation(animtranslate);
                if (txt_pass.length()>0){
                String pass=txt_pass.getText().toString();
                txt_pass.setText(pass.substring(0,pass.length()-1));
                }
            }
        });


        final SharedPreferences txtseting=getSharedPreferences("program codes", MODE_ENABLE_WRITE_AHEAD_LOGGING);

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animtranslate);
                if (firstinstal == 0) {

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(login.this);
                    if (txt_pass.length()==0)
                    {
                        builder1.setMessage("آیا می خواهید رمز عبور شما حذف شود؟");
                    }
                    else
                    {
                        builder1.setMessage("آیا می خواهید"+" ' "+txt_pass.getText().toString()+" ' "+"به عنوان رمز ورود شما انتخاب شود؟");
                    }
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "بله",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    SharedPreferences.Editor edi = txtseting.edit();
                                    edi.putString("password", txt_pass.getText().toString());
                                    if (txt_pass.length()==0)
                                    {
                                        edi.putInt("password cancel", 1);
                                    }
                                    else
                                    {
                                        edi.putInt("password cancel", 0);
                                    }
                                    edi.commit();
                                    Intent intent = new Intent(login.this, firstpage.class);
                                    startActivity(intent);
                                    final SharedPreferences.Editor edi1 = firstrun.edit();
                                    edi1.putInt("instal", 1);
                                    edi.commit();
                                    edi1.commit();
                                }
                            });

                    builder1.setNegativeButton(
                            "خیر",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else {
                    if (txt_pass.getText().toString().equals(txtseting.getString("password",null))){
                        Intent intent=new Intent(login.this, firstpage.class);
                        startActivity(intent);
                    }else
                    {
                        txt_pass.setText("");
                        Toast.makeText(getApplicationContext(),"رمز ورود اشتباه می باشد.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });





    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }



    public void showCustomAlert()
    {

        Context context = getApplicationContext();
// ساخت یک لایه با استفاده از toast.xml file
        LayoutInflater inflater = getLayoutInflater();

// فراخوانی لایه برای نمایش toast
        View toastRoot = inflater.inflate(R.layout.toast, null);

        Toast toast = new Toast(context);

// ست کردن مقادیر لایه به toast جهت نمایش
        toast.setView(toastRoot);
        toast.setGravity(Gravity.TOP,
                0, 300);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

    }



}
