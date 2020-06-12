package edmt.dev.androidgridlayout;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class WebScrapperLoan extends AppCompatActivity {

    Button hdfc;
    TextView hdfctext;
    TextView gendertext;
    Button gender;

    Button bp;
    TextView bptext;

    Button cholo;
    TextView cholotext;

    Button obes;
    TextView obestext;

    Button diab;
    TextView diabtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_scrapper_loan);


        hdfc = (Button) findViewById(R.id.hdfc);
        hdfctext = (TextView) findViewById(R.id.textView);

        gendertext = (TextView) findViewById(R.id.gendertext);
        gender = (Button) findViewById(R.id.gender);

        bptext =(TextView) findViewById(R.id.bptext);
        bp = (Button) findViewById(R.id.bp);

        cholotext =(TextView) findViewById(R.id.cholotext);
        cholo = (Button) findViewById(R.id.cholo);

        obestext = (TextView) findViewById(R.id.obestext);
        obes = (Button) findViewById(R.id.obesity);

        diabtext = (TextView) findViewById(R.id.diatext);
        diab = (Button) findViewById(R.id.dia);

        hdfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doit().execute();
            }
        });


        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doitg().execute();
            }
        });

        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doitb().execute();
            }
        });

        cholo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doitc().execute();
            }
        });

        obes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doito().execute();
            }
        });

        diab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doitd().execute();
            }
        });



    }




    public class doit extends AsyncTask<Void,Void,Void> {
        String content;
        String gender;
        int s,d;
        int st,de;
        String temp;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect("https://www.iob.in/Agricultural-term-loans").get();
                content = doc.text();


                s =  content.indexOf("Land Development");
                d =  content.indexOf("nearest IOB branch.");



                temp = String.valueOf(s);
                content = content.substring(s,d);



            } catch(Exception e){
                e.printStackTrace();

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            hdfctext.setText(content);
        }
    }


    public class doitg extends AsyncTask<Void,Void,Void> {
        String content;
        String gendert;
        int s,d;
        int st,de;
        String temp;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect("https://www.icicibank.com/rural/loans/farmer-finance/index.page").get();

                gendert = doc.text();



                st = gendert.indexOf("What are the types of agriculture loans available for me?");
                de = gendert.indexOf("loans are also available");

                temp = String.valueOf(s);

                gendert = gendert.substring(st,de);



            } catch(Exception e){
                e.printStackTrace();

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            gendertext.setText(gendert);
        }

    }

    public class doitb extends AsyncTask<Void,Void,Void> {
        String bpcontent;

        int s,d;
        int str,des;
        String temp;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect("https://www.hdfcbank.com/wholesale/fit/commodity_businesses/farmers_agriculturists/crop_loans.htm").get();
                bpcontent = doc.text();



                str = bpcontent.indexOf("Term Loans are provided ");
                des = bpcontent.indexOf("feasibility study.");

                temp = String.valueOf(s);
                bpcontent = bpcontent.substring(str,des);




            } catch(Exception e){
                e.printStackTrace();

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            bptext.setText(bpcontent);
        }
    }

    public class doitc extends AsyncTask<Void,Void,Void> {
        String ccontent;
        String gender;
        int s,d;
        int sts,ded;
        String temp;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect("https://www.govloans.gov/loans/loan-details/347").get();
                ccontent = doc.text();



                sts = ccontent.indexOf("General Program Requirements");
                ded = ccontent.indexOf("and refinancing debt.");

                temp = String.valueOf(s);
                ccontent = ccontent.substring(sts,ded);




            } catch(Exception e){
                e.printStackTrace();

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            cholotext.setText(ccontent);
        }
    }


    public class doito extends AsyncTask<Void,Void,Void> {
        String ocontent;

        int si,di;

        String temp;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect("https://www.govloans.gov/loans/loan-details/348").get();
                ocontent = doc.text();



                si = ocontent.indexOf("General Program Requirements");
                di = ocontent.indexOf("and promote soil and water conservation and protection.");




            } catch(Exception e){
                e.printStackTrace();

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            obestext.setText(ocontent);
        }
    }


    public class doitd extends AsyncTask<Void,Void,Void> {
        String dpcontent;

        int se,dr;
        String temp;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect("https://www.govloans.gov/loans/loan-details/349").get();
                dpcontent = doc.text();



                se = dpcontent.indexOf("General Program Requirements");
                dr = dpcontent.indexOf("and annual payments are required.");


                dpcontent = dpcontent.substring(se,dr);




            } catch(Exception e){
                e.printStackTrace();

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            diabtext.setText(dpcontent);
        }
    }



}

