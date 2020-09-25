package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int position = 0;
    private  ListView listView;
    ArrayList<String> list = new ArrayList<>();
    private  final String[] items={"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante","porttitor", "sodales", "pellentesque", "augue", "purus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setHomeButtonEnabled(true);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.idle:
                Toast.makeText(this,"Idle is pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.revert:
                Toast.makeText(this,"Revert is pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                add();
                listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void init()
    {
        listView = findViewById(R.id.list);
        add();
        listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list));
}
    private void add() {
        ArrayList<String> listInside = new ArrayList<>();
       int counter = 0;
        while (position < items.length && counter <=4)
        {
            listInside.add(items[position]);
            position++;
            counter++;
        }
        list.addAll(listInside);
    }

}