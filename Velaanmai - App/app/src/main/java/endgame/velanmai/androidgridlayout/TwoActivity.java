package edmt.dev.androidgridlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class TwoActivity extends AppCompatActivity {
    GridView gridView;

    String[] CropNames = {"Groundnut","Moong Dal"};
    int[] CropImages = {R.drawable.groundnut,R.drawable.moong};
    String[] cropinfo = new String[]{
            "Groundnut is perfectly grown in a well-drained sandy loam, or sandy clay soil.Deep well drained soil with a pH of 6.5-7.0 and high fertile and high fertility, are ideal for groundnut. An optimum soil temperature for good germination of groundnut is 30C. Low temperature at sowing delays germination and increases seed and seedling diseases. Soil test must be done before starting a groundnut farming .\n" +
                    "நிலக்கடலை நன்கு வடிகட்டிய மணல் களிமண் அல்லது மணல் களிமண் மண்ணில் வளரப்படுகிறது. 6.5-7.0 என்ற பி.ஹெ.ஹெச் மற்றும் பாசன மற்றும் உயர்ந்த கருவுறுதலுடன் நன்கு வடிகட்டிய மண்ணை நிலக்கடலைக்கு ஏற்றதாக இருக்கும். நிலக்கடலை நல்ல முளைப்பிற்கான உகந்த மண் வெப்பநிலை விதை மற்றும் தாவரம் நோய்கள் அதிகரிக்கிறது. நிலக்கடலை வளர்ப்பதற்கு முன்பு மண் பரிசோதனை மேற்கொள்ளப்பட வேண்டும்.",
            " Cultivation of Green gram is popularly known as Moong Dal in India and is widely cultivated throughout the Asia , including India.Best climatic conditions for green gramvation is warm humid and within temperature range of 25C - 30C with moderate rains of 85 to 100 cm well distributed throughout its growing period. +\n" +
                    "பசுமையான கிராம் பயிரிடுதல் இந்தியாவில் உள்ள மூங் டால் என பிரபலமாக அறியப்படுகிறது மற்றும் இந்தியா உட்பட இந்தியா முழுவதிலும் ஆசியா முழுவதும் பரவலாக பயிரிடப்படுகிறது. பச்சை நிற புல்வெளிகளுக்கான சிறந்த காலநிலை சூடான ஈரப்பதம் மற்றும் 25C - 30C வெப்பநிலை வரம்பிற்குள் மிதமான மழைக்காலங்களில் 85 முதல் 100 செ.மீ. அதன் வளர்ந்து வரும் காலம் முழுவதும்."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        //finding listview
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",CropNames[i]);
                intent.putExtra("image",CropImages[i]);
                intent.putExtra("info",cropinfo[i]);

                startActivity(intent);

            }
        });


    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return CropImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.fruits);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(CropNames[i]);
            image.setImageResource(CropImages[i]);
            return view1;



        }
    }
}
