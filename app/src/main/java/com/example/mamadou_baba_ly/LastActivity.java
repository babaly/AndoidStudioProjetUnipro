package com.example.mamadou_baba_ly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class LastActivity extends AppCompatActivity {
    VideoView videoView;
    Button btnUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_der);

        btnUrl = findViewById(R.id.urlbtn);

        videoView = findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));

    }

    public void gotoClick(View view) {
        gotoUrl("https://e-nipro.000webhostapp.com/");
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent. ACTION_VIEW, uri));
    }

    public void homeClick(View view) {
        Intent next = new Intent (this,HomeActivity.class);
        startActivity(next);
    }




}
