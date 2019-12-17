package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Github_act extends AppCompatActivity {

    private Spinner Sp;
    private TextView Txt;
    String[] precios = new String[]{"7000","22000","46000","87000","155000"};
    private Button BotonMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);
        Sp = (Spinner)findViewById(R.id.Sp_View);
        Txt = (TextView)findViewById(R.id.Txt_View);

        Bundle data = getIntent().getExtras();
        String[] libros = data.getStringArray("libros");

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,libros);

        Sp.setAdapter(adaptador);
    }


    public void Datos(View v){
        //"Farenheit", "Revival","El Alquimista","El poder","Despertar"
        String libro = Sp.getSelectedItem().toString();
        switch (libro) {
            case "Farenheit":
                String pc = precios[0];
                int precio = Integer.parseInt(pc);
                Txt.setText("El libro: "+libro+"\n"+"Cuesta: "+precio);
                break;
            case "Revival":
                pc = precios[1];
                precio = Integer.parseInt(pc);
                Txt.setText("El libro: "+libro+"\n"+"Cuesta: "+precio);
                break;
            case "Alquimista":
                pc = precios[2];
                precio = Integer.parseInt(pc);
                Txt.setText("El libro: "+libro+"\n"+"Cuesta: "+precio);
                break;
            case "El poder":
                pc = precios[3];
                precio = Integer.parseInt(pc);
                Txt.setText("El libro: "+libro+"\n"+"Cuesta: "+precio);
                break;
            case "Despertar":
                pc = precios[4];
                precio = Integer.parseInt(pc);
                Txt.setText("El libro: "+libro+"\n"+"Cuesta: "+precio);
                break;
        }
    }


}
