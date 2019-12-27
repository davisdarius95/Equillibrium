package com.example.dariusdavis.foodandfitness;


import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class AddFoodActivity extends AppCompatActivity{


    ExpandableListView expListView;
    List<String> listDataHeader = new ArrayList<String>();
    HashMap<String, List<String>> listDataChild = new HashMap<String, List<String>>();
    List<String> foodDatas = new ArrayList<String>();
    ExpandableListAdapter listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

    //UrlStream u = new UrlStream();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.foodsList);

        // preparing list data
        prepareListData();
        //new UrlStream().execute();
        //getFoodItems();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
       expListView.setAdapter(listAdapter);
    }

    final private String APP_KEY = "3ca24a623f3d4a1389e5f6d354bca4d7";
    final private String APP_SECRET = "e39c0fb051964a06a4a33c11d74b1874&";
    final String APP_URL = "http://platform.fatsecret.com/rest/server.api";
    final private String APP_SIGNATURE_METHOD = "HmacSHA1";
    final String HTTP_METHOD = "GET";

    String query;
    //JSONArray arr = new JSONArray();

    List<String> params = new ArrayList<>(Arrays.asList(generateOauthParameters()));
    String[] template = new String[1];


   public String nonce(){
        Random rand = new Random();
        StringBuilder buff = new StringBuilder();

        for(int i=0; i<rand.nextInt(8)+2; i++){
            buff.append(rand.nextInt(26)+'a');
        }
        return buff.toString();
    }

    public String[] generateOauthParameters(){
        return new String[]{
                "oauth_consumer_key=" + APP_KEY,        // Your API key when you registered as a developer
                "oauth_signature_method=HMAC-SHA1",     //The method used to generate the signature (only HMAC-SHA1 is supported)
                "oauth_timestamp=" +                    //The date and time, expressed in the number of seconds since January 1, 1970 00:00:00 GMT.
                        Long.valueOf(System.currentTimeMillis() * 2).toString(), // Should be  Long.valueOf(System.currentTimeMillis() / 1000).toString()
                "oauth_nonce=" + nonce(),               // A randomly generated string for a request that can be combined with the timestamp to produce a unique value
                "oauth_version=1.0",                    // MUST be "1.0"
                "format=json",                          // The desired response format. Valid reponse formats are "xml" or "json" (default value is "xml").
                "max_results=" + 20};                   // The maximum number of results to return (default value is 20). This number cannot be greater than 50.
    }

    public String join(String[] parameters, String separator){
        StringBuilder buffer = new StringBuilder();
        for(int i=0; i<parameters.length; i++){
            if(i>0){
                buffer.append(separator);
            }
            buffer.append(parameters[i]);
        }
        return buffer.toString();
    }

    public String makeParam(String[] params){
        String[] p = Arrays.copyOf(params, params.length);
        Arrays.sort(p);
        return join(p, "&");
    }

    public String encode(String url) {
        if (url == null)
            return "";

        try {
            return URLEncoder.encode(url, "utf-8")
                    .replace("+", "%20")
                    .replace("!", "%21")
                    .replace("*", "%2A")
                    .replace("\\", "%27")
                    .replace("(", "%28")
                    .replace(")", "%29");
        }
        catch (UnsupportedEncodingException wow) {
            throw new RuntimeException(wow.getMessage(), wow);
        }
    }

    public String sign(String method, String uri, String[] params) throws UnsupportedEncodingException {
        String[] p = {method, Uri.encode(uri), Uri.encode(makeParam(params))};
        String s = join(p, "&");
        SecretKey sk = new SecretKeySpec(APP_SECRET.getBytes(), APP_SIGNATURE_METHOD);
        try {
            Mac m = Mac.getInstance(APP_SIGNATURE_METHOD);
            m.init(sk);
            return Uri.encode(new String(Base64.encode(m.doFinal(s.getBytes()), Base64.DEFAULT)).trim());
        } catch (NoSuchAlgorithmException e) {
            Log.w("FatSecret_TEST FAIL", e.getMessage());
            return null;
        } catch (InvalidKeyException e) {
            Log.w("FatSecret_TEST FAIL", e.getMessage());
            return null;
        }
    }

    //called when the user clicks the search button
    public void getFoodItems(View view) /*throws UnsupportedEncodingException, JSONException*/ {
        UrlStream u = new UrlStream();

        EditText FoodSearch = (EditText) findViewById(R.id.txtFoodSearch);
        query = FoodSearch.getText().toString();
        u.execute(query);
        //u.onPostExecute();
        //expListView.setAdapter(listAdapter);
        /*List<String> params = new ArrayList<>(Arrays.asList(generateOauthParameters()));
        String[] template = new String[1];
        params.add("method=foods.search");
        params.add("search_expression=" + Uri.encode(query));
        params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

        JSONObject foods = new JSONObject();

        try {
            URL url = new URL(APP_URL + "?" + makeParam(params.toArray(template)));
            URLConnection api = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            Log.e("StringBuilder Works", "The StringBuilder works!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(api.getInputStream()));
            reader.reset();
            reader= new BufferedReader(new InputStreamReader(api.getInputStream()));
            Log.e("BufferReader Works", "The BufferReader works!");
            while ((line = reader.readLine()) != null) builder.append(line);
            JSONObject food = new JSONObject(builder.toString());   // { first
            foods = food.getJSONObject("food");                    // { second
        } catch (Exception exception) {
            Log.e("FatSecret Error", exception.toString());
            exception.printStackTrace();
        }*/
    }

    public void populateList(JSONArray ja){
        //ExpandableListView expListView = (ExpandableListView) findViewById(R.id.foodsList);
        try{
            for(int i=0; i<ja.length(); i++){
                JSONObject realObj = ja.getJSONObject(i);
                List<String> foodData = new ArrayList<String>();

                foodData.add(realObj.getString("food_description"));
                listAdapter.notifyDataSetChanged();
                listDataHeader.add(realObj.getString("food_name"));
                listAdapter.notifyDataSetChanged();
                foodData.add(realObj.getString("food_type"));
                listAdapter.notifyDataSetChanged();

                listDataChild.put(listDataHeader.get(i),foodData);
                listAdapter.notifyDataSetChanged();

                //expListView.setAdapter(listAdapter);
            }
        }catch (Exception exception) {
            Log.e("FatSecret Error", exception.toString());
            exception.printStackTrace();
        }
    }

    public void prepareListData(){
        foodDatas.add("Dummy data");
        listDataHeader.add("Dummy data");
        foodDatas.add("Dummy data");

        listDataChild.put(listDataHeader.get(0),foodDatas);
    }
}

