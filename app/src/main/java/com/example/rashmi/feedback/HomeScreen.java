package com.example.rashmi.feedback;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {
    EditText codeText;

    Button confirm;
   public Button linkButton;
   public TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        codeText= (EditText) findViewById(R.id.inputpassword);




        confirm= (Button) findViewById(R.id.submitPassword);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                Log.d("CLICK","INSIDE CONFIRM");
                String  code=codeText.getText().toString();

                Log.d("CODE",code);

                if(code.equals("200117")){
                    //Toast.makeText(getApplicationContext(),"WELCOME TO THE SEMINAR!",Toast.LENGTH_SHORT).show();
                    confirm.setVisibility(View.INVISIBLE);
                    codeText.setVisibility(View.INVISIBLE);
                    ImageView happylearnin= (ImageView) findViewById(R.id.happylearning);
                    happylearnin.setVisibility(View.VISIBLE);
                     welcome= (TextView) findViewById(R.id.welcome);
                    welcome.setVisibility(View.VISIBLE);
                    welcome.setText("HAPPY LEARNING!");
                    linkButton.setVisibility(View.VISIBLE);


                }
                else {
                    Toast.makeText(getApplicationContext(),"ENTER CORRECT CODE!",Toast.LENGTH_SHORT).show();
                 TextView   errorMessage= (TextView) findViewById(R.id.errorMessage);
                    errorMessage.setVisibility(View.VISIBLE);
                    errorMessage.setText("ENTER CORRECT CODE");

                }
            }
                catch (Exception ex) {
                    Toast.makeText(getApplicationContext(),"Unexpected Error",Toast.LENGTH_SHORT).show();
                    Log.d("ERROR",""+ex.toString());
                }


            }
        });
       linkButton= (Button) findViewById(R.id.linkButton);

        linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Feedback.class);


                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
