package edmt.dev.androidgridlayout;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class weather extends AppCompatActivity {
    Button click;
    public  static TextView data;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);



        click = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.textView);



        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherdata process = new weatherdata();
                process.execute();



                }
        });

    }









}
