package com.example.talong.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvmonhoc;
    ArrayList<String>arrayList;
    Button btnthem;
    EditText edtmonhoc;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvmonhoc =(ListView) findViewById(R.id.listviewmonhoc);

        btnthem= (Button)findViewById(R.id.btnthem);
        edtmonhoc=(EditText)findViewById(R.id.edtmonhoc);
        arrayList = new ArrayList<>();

        arrayList.add("anh van");
        arrayList.add("ngu van");
        arrayList.add("vat ly");

        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayList);
        lvmonhoc.setAdapter(adapter);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc= edtmonhoc.getText().toString();
                arrayList.add(monhoc);
                adapter.notifyDataSetInvalidated();
            }
        });


        lvmonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(id);
                adapter.notifyDataSetInvalidated();
                return false;
            }
        });
        lvmonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayList.get((int) id) , Toast.LENGTH_SHORT).show();
            }
        });
        lvmonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Long click:"+ id , Toast.LENGTH_SHORT).show();
                    return false;
               }
        });

    }
}
