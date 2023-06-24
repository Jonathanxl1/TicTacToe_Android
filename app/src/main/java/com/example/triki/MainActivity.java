package com.example.triki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button casilla1;
    private Button casilla2;
    private Button casilla3;
    private Button casilla4;
    private Button casilla5;
    private Button casilla6;
    private Button casilla7;
    private Button casilla8;
    private Button casilla9;

    private TextView txtJugador;
    private int jugador;
    private String [] [] array;

    private int row = 0 ;
    private int column = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        inicializar_array();



        Button arrayButtons[] = {casilla1,casilla2,casilla3,casilla4,casilla5,casilla6,casilla7,casilla8,casilla9};
        for(Button celda :arrayButtons){

            celda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String imprimir = validar_casilla(String.valueOf(celda.getText()));
                    array[row][column] = imprimir;
                    celda.setText(imprimir);
                    // cada 2 subo 1 nivel y subo la logica

                }
            });
            row+=1;
            if(row <= 2 || (row >= 3 && row <= 5) || (row >= 6 && row < 8) ){
                column += 1;
            }else if (row == 8){
                column = row = 0;
                break;
            }else{
                column = 0;
            }
        }
        /*
        casilla1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[0][0]);
                array[0][0] = imprimir;
                casilla1.setText(imprimir);
            }
        });

        casilla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[0][1]);
                array[0][1] = imprimir;
                casilla2.setText(imprimir);
            }
        });

        casilla3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[0][2]);
                array[0][2] = imprimir;
                casilla3.setText(imprimir);
            }
        });

        casilla4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[1][0]);
                array[1][0] = imprimir;
                casilla4.setText(imprimir);
            }
        });

        casilla5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[1][1]);
                array[1][1] = imprimir;
                casilla5.setText(imprimir);
            }
        });

        casilla6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[1][2]);
                array[1][2] = imprimir;
                casilla6.setText(imprimir);
            }
        });

        casilla7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[2][0]);
                array[2][0] = imprimir;
                casilla7.setText(imprimir);
            }
        });

        casilla8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[2][1]);
                array[2][1] = imprimir;
                casilla8.setText(imprimir);
            }
        });

        casilla9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imprimir = validar_casilla(array[2][2]);
                array[2][2] = imprimir;
                casilla9.setText(imprimir);
            }
        });

         */
    }

    private void inicializar(){
        casilla1 = (Button) findViewById(R.id.btn1);
        casilla2 = (Button) findViewById(R.id.btn2);
        casilla3 = (Button) findViewById(R.id.btn3);
        casilla4 = (Button) findViewById(R.id.btn4);
        casilla5 = (Button) findViewById(R.id.btn5);
        casilla6 = (Button) findViewById(R.id.btn6);
        casilla7 = (Button) findViewById(R.id.btn7);
        casilla8 = (Button) findViewById(R.id.btn8);
        casilla9 = (Button) findViewById(R.id.btn9);
        txtJugador = (TextView) findViewById(R.id.txtJugador);
        array = new String[3][3];
        jugador = 1;

    }

    private void inicializar_array (){
        for (int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                array[i][j] = "";
            }
        }
    }

    private String turnoJugador(){
        if (jugador == 1) {
            txtJugador.setText("Turno jugador " + jugador);
            jugador = 2;
            return "X";
        }
        else {
            txtJugador.setText("Turno jugador " + jugador);
            jugador = 1;
            return "O";
        }
    }

    private String validar_casilla(String celda){
        if(celda.equals("")){
            String imprimir = turnoJugador();
            return imprimir;
        }
        else {
            Toast.makeText(MainActivity.this, "No es posible realizar esta jugada intente de nuevo", Toast.LENGTH_SHORT).show();
            return celda;
        }
    }

}