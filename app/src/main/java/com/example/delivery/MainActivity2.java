package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {

    EditText txtName,txtAddress,txtPhone_No;
    Button button;
    DatabaseReference dbRef;
    Address add;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       txtName=findViewById(R.id.box1);
       txtAddress=findViewById(R.id.box2);
       txtPhone_No=findViewById(R.id.box3);

       button=findViewById(R.id.button3);

       add= new Address();


       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               dbRef= FirebaseDatabase.getInstance().getReference().child("Address").child("1");



               try {
                   if (TextUtils.isEmpty(txtName.getText().toString())) {
                       Toast.makeText(getApplicationContext(), "Empty Name", Toast.LENGTH_SHORT).show();
                      String id = dbRef.push().getKey();
                   }

                   else if (TextUtils.isEmpty(txtAddress.getText().toString())) {
                       Toast.makeText(getApplicationContext(), "Empty Address", Toast.LENGTH_SHORT).show();
                       String id = dbRef.push().getKey();
                   }

                   else if (TextUtils.isEmpty(txtPhone_No.getText().toString())) {
                       Toast.makeText(getApplicationContext(), "Empty Phone No", Toast.LENGTH_SHORT).show();
                       String id = dbRef.push().getKey();
                   }

                   else {
                       add.setName(txtName.getText().toString().trim());
                       add.setAddress(txtAddress.getText().toString().trim());
                       add.setPhone_No(txtPhone_No.getText().toString().trim());
                       String id = dbRef.push().getKey();
                       dbRef.child(id).setValue(add);
                       Toast.makeText(getApplicationContext(), "Successfully Added", Toast.LENGTH_SHORT).show();
                       clearControls();

                   }

               }
                   catch(NumberFormatException nfe) {
                        Toast.makeText(getApplicationContext(),"Invalid Phone No",Toast.LENGTH_SHORT).show();

               }




           }
       });

    }



   private void clearControls() {
        txtName.setText("");
        txtAddress.setText("");
        txtPhone_No.setText("");


   }






}








