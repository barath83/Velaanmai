package edmt.dev.androidgridlayout;

import android.content.Intent;
        import android.os.AsyncTask;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;




public class weatherdata extends AsyncTask<Void,Void,Void> {
    private String s1,s2,d,s3,s4;
    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    private int t,h,m,p;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?q=Chennai,In&appid=eb079721482c0dad5d77ee08973abffe&units=metric");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject JA = new JSONObject(data);
            JSONArray jr = JA.getJSONArray("list");
            for(int l = 0;l<40;l+=4) {

                JSONObject j = jr.getJSONObject(l);
                JSONArray w = j.getJSONArray("weather");

                for (int i = 0; i < w.length(); i++) {
                    JSONObject jb = w.getJSONObject(i);
                    singleParsed = "வானிலை தன்மை: " + jb.get("main") + "\n" +
                             "வானிலை :" + jb.get("description") ;

                    s1 = (String) jb.get("main");
                    s2 = (String) jb.get("description");

                    if(s1.equalsIgnoreCase("Clear"))
                    { s1 = "வானிலை தன்மை: தெளிவான வானிலை\nWeather Nature: Clear Sky";}
                    if(s1.equalsIgnoreCase("Clouds"))
                    { s1 = "வானிலை தன்மை: மேகமூட்டமான வானிலை\nWeather Nature: Overcast Clouds";}
                    if(s1.equalsIgnoreCase("Rain"))
                    {s1 = "வானிலை தன்மை: மழை\nWeather Nature: Rain";}

                    if(s2.equalsIgnoreCase("clear sky"))
                    { s2 = "வானிலை : தெளிந்த வானம்\nWeather: Clear Sky";}
                    if(s2.equalsIgnoreCase("few clouds"))
                    { s2 = "வானிலை : சில மேகங்கள் காணப்படுகின்றன\nFew clouds";}
                    if(s2.equalsIgnoreCase("broken clouds"))
                    {s2 = "வானிலை : உடைந்த மேகங்கள் தெரியும்\nBroken Clouds";}
                    if(s2.equalsIgnoreCase("scattered clouds"))
                    {s2 = "வானிலை : சிதறிய மேகங்கள் காணப்படுகின்றன\nScattered Clouds ";}
                    if(s2.equalsIgnoreCase("overcast clouds"))
                    {s2 = "வானிலை : இருண்ட மேகங்கள் காணப்படுகின்றன\nOvercast Clouds ";}
                    if(s2.equalsIgnoreCase("light rain"))
                    {s2 = "வானிலை : தூறல் மழை\nLittle train";}





                    dataParsed = dataParsed + s1 + "\n"+ s2+ "\n" + "தேதி மற்றும் நேரம்:" + j.get("dt_txt")+"\n"+"Date and Time:"+j.get("dt_txt")+"\n\n" ;

                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        weather.data.setText(this.dataParsed);






    }
}
