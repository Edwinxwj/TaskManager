package sg.edu.rp.c346.taskmanager;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView lv;
    ArrayList<Task> task;
    ArrayAdapter aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.lv);
        btnAdd = (Button)findViewById(R.id.buttonAdd);

//        Intent intentReceived = getIntent();
        DBHelper db = new DBHelper(MainActivity.this);
        task = db.getAllTasks();

        aa = new TaskArrayAdapter(MainActivity.this, R.layout.row, task) ;
        lv.setAdapter(aa);
        registerForContextMenu(lv);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(),AddActivity.class);
                startActivityForResult(i,9);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9 ) {
            DBHelper db = new DBHelper(MainActivity.this);
            task = db.getAllTasks();
            aa = new TaskArrayAdapter(MainActivity.this, R.layout.row, task);
            lv.setAdapter(aa);
        }
    }


}
