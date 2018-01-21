package com.example.david.actdialogos;


        import android.app.DatePickerDialog;
        import java.util.Calendar;
        import android.app.TimePickerDialog;
        import android.content.DialogInterface;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.TextView;
        import android.widget.TimePicker;


public class Principal extends AppCompatActivity implements View.OnClickListener{

    private Button botonFecha, botonHora, botonColor;
    private TextView editFecha, editHora, editColor;
    private int anyo, mes, dia, hora, minuto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        botonFecha = (Button) findViewById(R.id.botonFecha);
        botonHora = (Button) findViewById(R.id.botonHora);
        botonColor = (Button) findViewById(R.id.botonColor);
        editFecha = (TextView) findViewById(R.id.editFecha);
        editHora = (TextView) findViewById(R.id.editHora);
        editColor = (TextView) findViewById(R.id.editColor);

        botonFecha.setOnClickListener(this);
        botonHora.setOnClickListener(this);

    }

    public void onClick(View v) {

        if (v == botonFecha) {

            // Coge la fecha
            final Calendar c = Calendar.getInstance();
            anyo = c.get(Calendar.YEAR);
            mes = c.get(Calendar.MONTH);
            dia = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int anyo2,
                                              int mes2, int dia2) {

                            editFecha.setText(dia2 + "-" + (dia2 + 1) + "-" + anyo2);

                        }
                    }, anyo, mes, dia);
            datePickerDialog.show();
        }

        if (v == botonHora) {


            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minuto = c.get(Calendar.MINUTE);


            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hora2,
                                              int minuto2) {

                            editHora.setText(hora2 + ":" + minuto2);
                        }
                    }, hora, minuto, false);
            timePickerDialog.show();
        }

        if (v == botonColor){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Colors");
            builder.setPositiveButton("Verd",
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            editColor.setText("Verd");
                        }
                    });

            builder.setNeutralButton("Blau",
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            editColor.setText("Blau");
                        }
                    });

            builder.setNegativeButton("Roig",
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            editColor.setText("Roig");
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();

        }
    }


}

