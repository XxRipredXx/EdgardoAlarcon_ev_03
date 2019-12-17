package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BaseDeDatos extends AppCompatActivity {

    EditText codigo, nombre, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_de_datos);

        codigo = (EditText)findViewById(R.id.codigoView);
        nombre = (EditText)findViewById(R.id.nombreView);
        precio = (EditText)findViewById(R.id.precioView);

    }

    public void AñadirLibro(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Biblioteca",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();//se usa para sobreescribir en la DB

        String cod = codigo.getText().toString();
        String nom = nombre.getText().toString();
        String prec = precio.getText().toString();

        if(!cod.isEmpty() && !nom.isEmpty() && !prec.isEmpty()){
            ContentValues reg = new ContentValues();
            reg.put("codigo",cod);
            reg.put("nombre",nom);
            reg.put("precio",prec);

            BaseDeDatos.insert("libros",null,reg);
            BaseDeDatos.close();

            Toast.makeText(this, "Insercion Exitosa", Toast.LENGTH_LONG).show();
        }
    }

    public void UpgradeLibro(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Biblioteca",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String cod = codigo.getText().toString();
        String nom = nombre.getText().toString();
        String prec = precio.getText().toString();

        if(!cod.isEmpty() && !nom.isEmpty() && !prec.isEmpty()){
            ContentValues reg = new ContentValues();
            reg.put("codigo",cod);
            reg.put("nombre",nom);
            reg.put("precio",prec);

            BaseDeDatos.update("libros", reg ,"codigo="+cod ,null);
            BaseDeDatos.close();

            Toast.makeText(this, "Datos Actualizados ID: "+cod, Toast.LENGTH_LONG).show();
        }
    }

    public void DaleteLibro(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Biblioteca",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String cod = codigo.getText().toString();

        BaseDeDatos.delete("libros","codigo="+cod,null);
        BaseDeDatos.close();

        Toast.makeText(this, "Producto ID: "+cod+" Eliminado", Toast.LENGTH_LONG).show();
    }

}
