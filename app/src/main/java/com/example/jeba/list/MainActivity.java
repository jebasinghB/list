package com.example.jeba.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList <String> addArray = new ArrayList<String>();
    ListView ls;
    EditText nam;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nam=(EditText)findViewById(R.id.name);
        ls=(ListView)findViewById(R.id.lst);
        save=(Button)findViewById(R.id.btn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getinput =nam.getText().toString();
                if(addArray.contains(getinput)){
                    Toast.makeText(getBaseContext(),"already exist",Toast.LENGTH_LONG).show();

                }
                else if(getinput ==null){
                    Toast.makeText(getBaseContext(),"empty field",Toast.LENGTH_LONG).show();

                }
                else{
                    addArray.add(getinput);
                    ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,addArray);
                    ls.setAdapter(adapter);
                    nam.setText("");
                }
            }
        });

    }
}
