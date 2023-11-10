package com.example.player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnPlayProg,btnStopProg;
    TextView txtMusicPlayerProg;
    TextView txtTituloProg;
    MediaPlayer mp;
    Animation txtDeslizando;
    Animation rotacao;
    ImageView imgRodando;
    int status1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        btnPlayProg = findViewById(R.id.btnPlay);
        btnStopProg = findViewById(R.id.btnStop);
        txtTituloProg = findViewById(R.id.txtTitulo);
        txtMusicPlayerProg = findViewById(R.id.txtTitulo);
        imgRodando = findViewById(R.id.imgDisco);

        rotacao = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotacao);
        rotacao.setRepeatCount(Animation.INFINITE);

        txtDeslizando = new TranslateAnimation(1080, -1080, 0, 0);
        txtDeslizando.setDuration(5000); // Define a duração da animação em milissegundos
        txtDeslizando.setRepeatCount(Animation.INFINITE); // Define que a animação se repita infinitamente
        txtDeslizando.setInterpolator(new LinearInterpolator());


        btnPlayProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status1 == 0){
                    mp = MediaPlayer.create(MainActivity.this,R.raw.semana);
                    mp.start();
                    status1 = 1;
                    btnPlayProg.setBackgroundResource(R.drawable.pause_buttom);
                    txtTituloProg.setText("Mais uma semana.mp3");
                    imgRodando.setImageResource(R.drawable.discopronto);
                    imgRodando.startAnimation(rotacao);
                    txtTituloProg.startAnimation(txtDeslizando);

                } else if(status1 == 1){
                    mp.pause();
                    status1 = 2;
                    btnPlayProg.setBackgroundResource(R.drawable.play_buttom);
                    rotacao.cancel();
                    txtDeslizando.cancel();

                }else if(status1 == 2){
                    mp.start();
                    status1 = 1;
                    btnPlayProg.setBackgroundResource(R.drawable.pause_buttom);
                    imgRodando.startAnimation(rotacao);
                    txtTituloProg.startAnimation(txtDeslizando);
                }
            }
        });

        btnStopProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                status1 = 0;
                btnPlayProg.setBackgroundResource(R.drawable.play_buttom);
                txtTituloProg.setText("");
                imgRodando.setImageResource(R.drawable.disco);
                rotacao.cancel();
                txtDeslizando.cancel();
            }
        });
    }
}