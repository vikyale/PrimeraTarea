package gdgwoman.com.primeratarea;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import helper.DatabaseHelper;


public class MyActivity extends Activity implements View.OnClickListener {
    //declarando mis variables internas
    EditText txtnom, txtpass;
    Button ingresar;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DatabaseHelper(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtnom = (EditText) findViewById(R.id.edtUser);
        txtpass = (EditText) findViewById(R.id.edtPsw);
        ingresar = (Button) findViewById(R.id.btnLogin);
        ingresar.setOnClickListener(this);
    }


    public void validar(View v) {
        String login;
        //no seria defrente if (txtnom.length()==0 ) ?
        login = txtnom.getText().toString();
        if (login.length() == 0) {
            txtnom.setError("Ingresar nombre");
            txtnom.setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        String nombre, pass;
        nombre = txtnom.getText().toString();
        pass = txtnom.getText().toString();

        if (nombre.length() == 0) {

            Toast.makeText(getApplicationContext(), "Ingresa tu usuario", Toast.LENGTH_SHORT).show();

        }
        if (pass.length() == 0) {
            Toast.makeText(getApplicationContext(), "Ingresa tu password", Toast.LENGTH_SHORT);
        } else if (db.getTODO(nombre, pass) == 0) {
            Toast.makeText(getApplicationContext(), "Se equivoco", Toast.LENGTH_SHORT);
        } else {
            Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
        }


    }
}
