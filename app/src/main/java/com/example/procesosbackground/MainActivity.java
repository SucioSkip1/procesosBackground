          package com.example.procesosbackground;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

          public class MainActivity extends AppCompatActivity {
TextView txtContador;
int time=0;
int rate=100;
Timer timer;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtContador = findViewById(R.id.contador);
        timer = new Timer("Temporizador");
        Tarea tarea = new Tarea();
        timer.scheduleAtFixedRate(tarea, 0, rate);

    }

              @Override
              protected void onPause() {
                  super.onPause();
                  timer.cancel();
              }
              class Tarea extends TimerTask{


                  @Override
                  public void run() {
                      Runnable cambiaTexto = new CambiaTexto();
                      runOnUiThread(cambiaTexto);
                  }
              }
              class CambiaTexto implements Runnable{

                  @Override
                  public void run() {
                      time=time+rate;
                      String texto="Temporizador \n rate= "+rate+"\n t = "+time;
                        txtContador.setText(texto);
                      txtContador.setTypeface(null, Typeface.BOLD);
                      txtContador.setTextSize(30);


                  }
              }






          }