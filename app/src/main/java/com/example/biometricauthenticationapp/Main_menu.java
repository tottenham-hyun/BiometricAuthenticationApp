package com.example.biometricauthenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main_menu extends AppCompatActivity {
    private ImageView sunil_world_icon;
    private ImageView sunil_office_icon;
    private ImageView sunil_defense_icon;
    private ImageView sunilun_icon;
    private ImageView sunil_page_icon;
    private ImageView fingerprint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        sunil_world_icon = findViewById(R.id.sunil_world_icon);
        sunil_office_icon = findViewById(R.id.sunil_office_icon);

        sunil_defense_icon = findViewById(R.id.sunil_defense_icon);
        sunilun_icon = findViewById(R.id.sunilun_icon);

        sunil_page_icon = findViewById(R.id.sunil_page_icon);
        fingerprint = findViewById(R.id.fingerprint_icon);

        //이미지 버튼 작동
        sunil_world_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String url = "https://www.roblox.com/games/9548487158/unnamed";
                    Intent intentPlayStore = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intentPlayStore);
                }catch (Exception e){
                    move_roblox();
                }
            }
        });

        sunil_office_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String url = "https://www.roblox.com/games/10973134854/unnamed";
                    Intent intentPlayStore = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intentPlayStore);
                }catch (Exception e){
                    move_roblox();
                }
            }
        });

        sunil_defense_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String url = "https://www.roblox.com/games/11348810742/Defense";
                    Intent intentPlayStore = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intentPlayStore);
                }catch (Exception e){
                    move_roblox();
                }
            }
        });

        sunilun_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String url = "https://www.roblox.com/games/11186037100/SuniLuns";
                    Intent intentPlayStore = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intentPlayStore);
                }catch (Exception e){
                    move_roblox();
                }
            }
        });

        sunil_page_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_menu.this, WebViewActivity.class);
                startActivity(intent);
            }
        });

        fingerprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_menu.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
    public void move_roblox(){
        String url = "market://details?id=" + "com.roblox.client"; // 로블록스 설치 링크
        Intent intentPlayStore = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intentPlayStore);
    }
}