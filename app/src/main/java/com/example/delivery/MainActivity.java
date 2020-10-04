package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

   String[] listItems;
   Button btn1;
   TextView mTextView;


    FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    btn1=findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listItems = new String[] {"Edit","Delete"};
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);

                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mTextView.setText(listItems[i]);
                        dialogInterface.dismiss();

                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });















        OnclickButtonLister();

    }

    public boolean onOptionsItemSelected(MenuItem item){
         int id= item.getItemId();

         if (id==R.id.add1) {

             Intent i =new Intent(MainActivity.this,MainActivity3.class);
             startActivity(i);
             return true;
         }

          return super.onOptionsItemSelected(item);


    }












    public void OnclickButtonLister(){
        button= (FloatingActionButton) findViewById(R.id.plusButton);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                       
                    }
                }

        );



    }





}