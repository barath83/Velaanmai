package edmt.dev.androidgridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class longweather extends AppCompatActivity {

    TextView display;
    Button press;
    EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longweather);
        Firebase.setAndroidContext(this);

        Firebase ret;



        ret = new Firebase("https://pythonex-54fe2.firebaseio.com/weather/rainfall");


        ret.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                display.setText(value);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        display = (TextView) findViewById(R.id.textView4);
        value =(EditText) findViewById(R.id.enter);
        press = (Button) findViewById(R.id.button2);

        final Firebase mRef;



        mRef = new Firebase("https://pythonex-54fe2.firebaseio.com/query");
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int response = Integer.parseInt(value.getText().toString());

                Firebase mRefChild = mRef.child("month");
                mRefChild.setValue(response);
            }
        });






    }
}
