package edmt.velanmai.androidgridlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ActivityOne extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        listView = (ListView) findViewById(R.id.list);
        String[] values = new String[]{"Red Soil\nசிவப்பு மண்", "Black Soil\nகருப்பு மண்"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(position==0){
                    Intent intent = new Intent(ActivityOne.this, TwoActivity.class);
                    startActivityForResult(intent,0);
            }
            if(position==1){
                    Intent intent = new Intent(ActivityOne.this,blacksoil.class);
                     startActivityForResult(intent,1);
            }
        }
    });
}
}


