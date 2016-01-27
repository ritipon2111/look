package com.example.asus.look;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Explicit ประกาศตัวแปร
    private ImageView paperImageView, rockImageView, scissorImageView, playImageView, androidImageView;
    private TextView showTextView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind widget
        bindWidget();

        //Paper Controltor
        paperControltor();

        //Rock Controltor
        rockControltor();

        // scissor Controltor
        scissorControltor();



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    } // Main Method

    private void scissorControltor() {
        scissorImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intNumber = 3;
                changePlay(intNumber);
                myRandomPicture(3);
            }
        });
    } //  scissorControltor

    private void rockControltor() {
        rockImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intNumber = 2;
                changePlay(intNumber);
                myRandomPicture(2);



        }
        });
    } // rockControltor

    private void paperControltor() {
        paperImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intNumber = 1;
                changePlay(intNumber);
                myRandomPicture(1);
            }
        });

    } // paperControltor

    private void myRandomPicture(int intUser) {

        int intMyRandom = 0;
        Random objRandom = new Random();
        intMyRandom = objRandom.nextInt(3) +1;
        Log.d("Ran","intMyRandom ==> " + intMyRandom);
        androidChange(intMyRandom);
        checkScore(intUser, intMyRandom);

    }// myRandomPicture

    private void checkScore(int intUser, int intMyRandom) {
        String strWin = "โอ้โหเก่งจัง ชนะเถอะ";
        String strLost = "ไปฝึกมาใหม่น่ะน้อง";
        String strDrew = "ไม่น่าเลย น่าแม่นนน";
        String strShow = null;
        int[] intSound = new int[3];
        intSound[0] = R.raw.cow;

        //1 ==>กระดาษ,//2 ==> ค้อน,//3 ==> กรรไกร
        switch (intUser) {
            case 1: //กระดาษ
                switch (intMyRandom) {
                    case 1:
                        strShow = strDrew;
                        break;
                    case 2:
                        strShow = strWin;
                        break;
                    case 3:
                        strShow = strLost;
                        break;
                }
                break;
            case 2: //ค้อน
                switch (intMyRandom) {
                    case 1:
                        strShow = strLost;
                        break;
                    case 2:
                        strShow = strDrew;
                        break;
                    case 3:
                        strShow = strWin;
                        break;
                }
                break;
            case 3://กรรไกร
                switch (intMyRandom) {
                    case 1:
                        strShow = strWin;
                        break;
                    case 2:
                        strShow = strLost;
                        break;
                    case 3:
                        strShow = strDrew;
                        break;
                }
                break;


        } // switch
        showTextView.setText(strShow);

    }//checkScore

    private void androidChange(int intMyRandom) {
        int[] intSourceImage = new int[4];
        intSourceImage[0] = 0;
        intSourceImage[1] = R.drawable.paper;
        intSourceImage[2] = R.drawable.rock;
        intSourceImage[3] = R.drawable.scissors;

        androidImageView.setImageResource(intSourceImage[intMyRandom]);
    } // androidchang

    private void changePlay(int intNumber) {
        Log.d("test", "ค่าที่รับได้ = " + intNumber);
        int intSound = R.raw.cow;
        switch (intNumber) {
            case 1:
                playImageView.setImageResource(R.drawable.paper);
                intSound = R.raw.cow;
                break;
            case 2:
                playImageView.setImageResource(R.drawable.rock);
                intSound = R.raw.cow;
                break;
            case 3:
                playImageView.setImageResource(R.drawable.scissors);
                intSound = R.raw.cow;
                break;

        } // switch
    } // changPlay

    private void bindWidget() {
        paperImageView = (ImageView) findViewById(R.id.imvPaper);
        rockImageView = (ImageView) findViewById(R.id.imvKron);
        scissorImageView = (ImageView) findViewById(R.id.imvKankai);
        playImageView = (ImageView) findViewById(R.id.imvPlayer);
        androidImageView = (ImageView) findViewById(R.id.imvAndroid);
        showTextView = (TextView) findViewById(R.id.txtShow);


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.asus.look/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.asus.look/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
} // Main class คลาสหลัก
