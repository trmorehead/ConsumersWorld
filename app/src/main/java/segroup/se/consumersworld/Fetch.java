package segroup.se.consumersworld;

import android.util.Log;
import android.os.AsyncTask;

import org.json.JSONTokener;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Fetch class will fetch a JSON file from www.openexchangerates.org.
 * The resulting JSON file will be parsed using the GSON library.
 * Once parsed the 10 currencies will be written to a local text file.
 * Created by tmore on 12/5/2015.
 */
public class Fetch extends AsyncTask<Void, Void, JSONObject>
{
    Exception Exception;
    //https://openexchangerates.org/api/latest.json?app_id=56eecba260d044edbd11c2b2a772f261
    String urlMain = "https://openexchangerates.org/api/";
    String urlLatest = "latest.json";
    String apiKeyPrefix ="app_id=";
    String apiKeyID = "56eecba260d044edbd11c2b2a772f261";
    JSONObject object;
    /**
     * constructor
     */
    public Fetch()
    {

    }

    /**
     *
     */
    public void onPreExecute()
    {
        //progressBar.setVisibility(View.VISIBLE);
        //responseView.setText("");
    }

    /**
     *
     * @return JSONObject
     */
    public JSONObject doInBackground(Void...urls)
    {
        try {
            StringBuilder urlString = new StringBuilder();
            urlString.append(urlMain + urlLatest + apiKeyPrefix + apiKeyID);

            URL url = new URL(urlString.toString());
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            try
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null)
                {
                    sb.append(line).append("\n");
                }
                br.close();

                object = (JSONObject) new JSONTokener(sb.toString()).nextValue();

                FileWriter file = new FileWriter(".../file1.txt");
                file.write(object.toJSONString());
            }
            finally
            {
                urlConnection.disconnect();
            }
        }
        catch(Exception e)
        {
            Log.e("ERROR", e.getMessage(), e);
        }
        return object;
    }

    /**
     *
     */
    public void onProgressUpdate()
    {

    }

    /**
     *
     */
    public void onPostExecute()
    {
        //if(line == null)
        //{
        //    line = "THERE WAS AN ERROR";
        //}
        //progressBar.setVisibility(View.GONE);
        //Log.i("INFO", line);
        //lineView.setText(line);
    }
}
