package gdgwoman.com.primeratarea;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;



import gdgwoman.com.primeratarea.R;

public class Menu extends Activity{

    Button pro ;
    Button alerta ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        pro=(Button)findViewById(R.id.btnPro);
      //  pro.setOnClickListener(this);

        alerta=(Button)findViewById(R.id.btnAlerta);
        //alerta.setOnClickListener(this);



    }






}




