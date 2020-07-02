package com.example.android.quiz_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int peruPunto=0,puntos=0,fin=0,respuestasIncorrectas;
    boolean r1pregunta2,r2pregunta2,r3pregunta2,r4pregunta2,r1pregunta3;
    String arequipaFundacion="1540",arequipaRespuesta,puntuacionfinal="",inco;

    public  void latviaclick(View view){
        if(peruPunto==1){
            puntos=puntos-1;
            peruPunto=0;
        }
        Toast.makeText(this,  getText(R.string.respuestaenviada), Toast.LENGTH_SHORT).show();
    }

    public void peruclick(View view){
        if(peruPunto==0){
            puntos++;
            peruPunto=1;
        }
        Toast.makeText(this,  getText(R.string.respuestaenviada), Toast.LENGTH_SHORT).show();
    }

    public void canadaclick(View view){
        if(peruPunto==1){
            puntos=puntos-1;
            peruPunto=0;
        }
    }

   public void pregunta2(boolean rpt1,boolean rpt2,boolean rpt3,boolean rpt4){

          if(rpt1 && !rpt2 && !rpt3 && !rpt4 ){
              puntos++;
          }
          else {
              respuestasIncorrectas++;
          }
   }

    public void pregunta3(boolean rpt){

        if (rpt){
            puntos=puntos+1;
        }
        else {
            respuestasIncorrectas++;
        }
    }

    public void pregunta4(String respuestaCorrecta,String respuestaEnviada){

        if (respuestaEnviada.equals(respuestaCorrecta))
        {
            puntos++;
        }
        else respuestasIncorrectas++;
    }

    public void enviarc(View view){

        if (fin==1){
            Toast.makeText(this, getText(R.string.surespuesta), Toast.LENGTH_SHORT).show();
            return;
        }

        if (peruPunto==0){
            respuestasIncorrectas++;
        }

        CheckBox espania=(CheckBox)findViewById(R.id.espana);
        r1pregunta2=espania.isChecked();
        CheckBox ingla=(CheckBox)findViewById(R.id.inglaterra);
        r2pregunta2=ingla.isChecked();
        CheckBox rom=(CheckBox)findViewById(R.id.romano);
        r3pregunta2=rom.isChecked();
        CheckBox irlan=(CheckBox)findViewById(R.id.irlanda);
        r4pregunta2=irlan.isChecked();
        pregunta2(r1pregunta2,r2pregunta2,r3pregunta2,r4pregunta2);
        RadioButton espa_radio=(RadioButton)findViewById(R.id.radio_espania);
        r1pregunta3=espa_radio.isChecked();
        pregunta3(r1pregunta3);
        EditText fundacionEnviada=(EditText)findViewById(R.id.arequipa_pregunta);
        arequipaRespuesta=fundacionEnviada.getText().toString();
        pregunta4(arequipaFundacion,arequipaRespuesta);
        Toast.makeText(this, getText(R.string.respuestaenviada), Toast.LENGTH_SHORT).show();
        fin++;
        puntuacionfinal=getString(R.string.respuestascorrectas);
        puntuacionfinal=puntuacionfinal+" "+puntos;
        inco=getString(R.string.respuestasinco);
        puntuacionfinal=puntuacionfinal+" " + inco +" " + respuestasIncorrectas;
    }

    public void revisar(View view){
        Toast.makeText(this, puntuacionfinal, Toast.LENGTH_SHORT).show();
    }

}
