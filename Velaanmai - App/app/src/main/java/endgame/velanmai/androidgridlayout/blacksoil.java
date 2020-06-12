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

public class blacksoil extends AppCompatActivity {
    GridView gridView;

    String[] CropNames = {"Cotton","Tobacco"};
    int[] CropImages = {R.drawable.cotton,R.drawable.tobacco};
    String[] Cropinfo = {"Cotton is a plant that needs a long frost-free period, a lot of heat and plenty of sunshine. It prefers warm and humid climate. Cotton seeds will have a small germination rate, if the soil temperature is below 60°F (15°C). During active growth, the ideal air temperature is 70 to 100°F (21-37°C). Temperatures well above 100°F are not desirable. However, the average cotton plant can survive in temperatures up to 110°F (43°C) for short periods without great damage, but this also depends on the humidity levels. In order to cultivate cotton plants successfully, we shall not have frequent rainfalls during the maturing (summer) and during the days of harvest (during autumn).\n\nபருத்தி என்பது ஒரு நீண்ட உறைபனி இல்லாத காலம், நிறைய வெப்பம் மற்றும் சூரிய ஒளி நிறைய இருக்கிறது. இது சூடான மற்றும் ஈரப்பதமான சூழலை விரும்புகிறது. மண் வெப்பநிலை 60 ° F (15 ° C) குறைவாக இருந்தால், பருத்தி விதைகள் ஒரு சிறிய முளைப்பு விகிதத்தைக் கொண்டிருக்கும். தீவிர வளர்ச்சியின் போது, \u200B\u200Bசிறந்த காற்று வெப்பநிலை 70 முதல் 100 ° F (21-37 ° C) ஆகும். வெப்பநிலையானது 100 ° F க்கு மேலானது விரும்பத்தக்கதாக இல்லை. இருப்பினும், சராசரி பருத்தி ஆலை குறைந்தபட்சம் 110 ° F (43 ° C) வெப்பநிலையில் மிகக் குறைந்த சேதம் இல்லாமல் வாழ முடியும், ஆனால் இது ஈரப்பதம் அளவை பொறுத்தது. பருத்தி ஆலைகளை வெற்றிகரமாக பயிரிடுவதற்காக, முதிர்ச்சியடையும் (கோடைகாலத்தில்) மற்றும் அறுவடை நாட்களில் (இலையுதிர்காலத்தில்) அடிக்கடி மழைப்பொழிவு இருக்காது.",
            "Tobacco seeds are extremely small not much larger than a pin prick and care should be taken when sowing seed as to not sow to thickly. Tobacco seed require warm temperatures for germination of about 75-80 degrees. Seed should be started indoors 4-6 weeks before your last frost date. Start by sprinkling the tobacco seed onto the surface of a sterile seed starting mix and lightly water in.,\n\nபுகையிலை விதைகளை ஒரு சிறு முள்ளம்பன்றி விட பெரியதாக இல்லை, விதை விதைகளை விதைக்கும்போது தடிமனாக விதைக்கப்படாமல் இருக்க வேண்டும். புகையிலை விதை 75-80 டிகிரி முளைப்புக்காக சூடான வெப்பநிலை தேவைப்படுகிறது. உங்கள் கடைசி உறைபனி தேதிக்கு 4-6 வாரங்களுக்கு முன்னரே விதை ஆரம்பிக்க வேண்டும். ஒரு விதை விதை ஆரம்ப கலவையின் மேற்பரப்பில் புகையிலை விதை தெளிப்பதன் மூலம் தொடங்குங்கள் மற்றும் சிறிது நீர்."};
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
//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",CropNames[i]);
                intent.putExtra("image",CropImages[i]);
                intent.putExtra("info",Cropinfo[i]);
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
