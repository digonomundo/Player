package com.example.player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnPlayProg,btnStopProg;
    TextView txtMusicPlayerProg;
    TextView txtTituloProg;
    MediaPlayer mp;

    int tempoPausado;
    int status1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayProg = findViewById(R.id.btnPlay);
        btnStopProg = findViewById(R.id.btnStop);
        txtTituloProg = findViewById(R.id.txtTitulo);
        txtMusicPlayerProg = findViewById(R.id.txtTitulo);

        btnPlayProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status1 == 0){
                    mp = MediaPlayer.create(MainActivity.this,R.raw.semana);
                    mp.start();
                    status1 = 1;
                    btnPlayProg.setText("PAUSE");
                    txtTituloProg.setText("titulo: Mais uma semana.mp3");
                } else if(status1 == 1){
                    mp.pause();
                    status1 = 2;
                    btnPlayProg.setText("PLAY");
                }else if(status1 == 2){
                    mp.start();
                    status1 = 1;
                    btnPlayProg.setText("PAUSE");
                }
            }
        });

        btnStopProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                status1 = 0;
                btnPlayProg.setText("PLAY");
                txtTituloProg.setText("Título");
            }
        });
    }
}