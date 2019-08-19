package com.example.ahmad.hka_1;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class suport extends AppCompatActivity {


    int size;
    Typeface textfont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suport);
        Toolbar toolbar3 = (Toolbar) findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String languageload = "en";
        Locale locale = new Locale(languageload);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        final SharedPreferences shp = getSharedPreferences("sett", MODE_PRIVATE);
        size = shp.getInt("size", 16);

        textfont = Typeface.createFromAsset(getAssets(),"fonts/yekan.ttf");
        TextView pagename = (TextView) findViewById(R.id.pagename);

        pagename.setTextSize(size);
        pagename.setTypeface(textfont);

        ImageView call1 = (ImageView) findViewById(R.id.call1);
        ImageView call2 = (ImageView) findViewById(R.id.call2);
        ImageView call3 = (ImageView) findViewById(R.id.call3);
        ImageView site = (ImageView) findViewById(R.id.site);
        ImageView email = (ImageView) findViewById(R.id.email);


        site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.hka.ir";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "hka.ir.co@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });


        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder1 = new AlertDialog.Builder(suport.this);
                builder1.setMessage("آیا می خواهید با شماره 01133268868 تماس بگیرید؟.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "بله",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                try {
                                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                                    callIntent.setData(Uri.parse("tel:+981133268868"));
                                    if (ActivityCompat.checkSelfPermission(suport.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                        return;
                                    }
                                    startActivity(callIntent);
                                } catch (ActivityNotFoundException activityException) {
                                    Log.e("helloandroid dialing example", "Call failed");
                                }
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


            }
        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(suport.this);
                builder1.setMessage("آیا می خواهید با شماره 01133268869 تماس بگیرید؟.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "بله",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                try {
                                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                                    callIntent.setData(Uri.parse("tel:+981133268869"));
                                    if (ActivityCompat.checkSelfPermission(suport.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                        return;
                                    }
                                    startActivity(callIntent);
                                } catch (ActivityNotFoundException activityException) {
                                    Log.e("helloandroid dialing example", "Call failed");
                                }
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
            }
        });

        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(suport.this);
                builder1.setMessage("آیا می خواهید با شماره 01133268871 تماس بگیرید؟.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "بله",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                try {
                                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                                    callIntent.setData(Uri.parse("tel:+981133268871"));
                                    if (ActivityCompat.checkSelfPermission(suport.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                        return;
                                    }
                                    startActivity(callIntent);
                                } catch (ActivityNotFoundException activityException) {
                                    Log.e("helloandroid dialing example", "Call failed");
                                }
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
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id==android.R.id.home){
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
