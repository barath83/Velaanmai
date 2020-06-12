package edmt.dev.androidgridlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class GridItemActivity extends AppCompatActivity {

    TextView name;
    TextView desc;
    ImageView image;
    private Button button;
    GridView gridView;
    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);
        Firebase.setAndroidContext(this);


        name = findViewById(R.id.griddata);
        image = findViewById(R.id.imageView);
        desc = findViewById(R.id.textView);


        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image", 0));
        desc.setText(intent.getStringExtra("info"));



        button = (Button) findViewById(R.id.button);
        mRef = new Firebase("https://pythonex-54fe2.firebaseio.com/selection");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String response = null;
                if (name.getText().toString().equalsIgnoreCase("Rice"))
                                response = String.valueOf(2);
                Firebase mRefChild = mRef.child("codeno");
                mRefChild.setValue(response);
                    openrawdata();
                if (name.getText().toString().equalsIgnoreCase("Groundnut"))
                  response = String.valueOf(2);
                Firebase mRefChildr = mRef.child("codeno");
                mRefChildr.setValue(response);
                    openrawground();
                if (name.getText().toString().equalsIgnoreCase("Moong Dal"))
                    response = String.valueOf(5);
                Firebase mRefChildv = mRef.child("codeno");
                mRefChildv.setValue(response);
                    openmoongdata();
                if (name.getText().toString().equalsIgnoreCase("Cotton"))
                    response = String.valueOf(4);
                Firebase mRefChilds = mRef.child("codeno");
                mRefChilds.setValue(response);
                    opencottondata();
                if (name.getText().toString().equalsIgnoreCase("Tobacco"))
                    response = String.valueOf(3);
                Firebase mRefChildt = mRef.child("codeno");
                mRefChildt.setValue(response);
                    opentobacco();


            }
        });
    }

    public void openrawdata() {
        Intent intent1 = new Intent(this, rawdata.class);
        startActivity(intent1);
    }

    public void openrawground() {
        Intent intent1 = new Intent(this, groundnutdata.class);
        startActivity(intent1);
    }

    public void openmoongdata() {
        Intent intent1 = new Intent(this, Moongdata.class);
        startActivity(intent1);

    }

    public void opencottondata() {
        Intent intent1 = new Intent(this, cottondata.class);
        startActivity(intent1);

    }
    public void opentobacco() {
        Intent intent1 = new Intent(this, tobacco.class);
        startActivity(intent1);

    }


}
