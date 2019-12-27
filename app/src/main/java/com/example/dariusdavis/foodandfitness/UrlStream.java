package com.example.dariusdavis.foodandfitness;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CS Student on 3/22/2017.
 */

public class UrlStream extends AsyncTask<String, Void,JSONArray>{

    JSONArray arr = new JSONArray();
    JSONObject foods = new JSONObject();
    //ArrayList<String> listDataHeader = new ArrayList<String>();
    //HashMap<String, List<String>> listDataChild = new HashMap<String, List<String>>();
    AddFoodActivity af = new AddFoodActivity();

    //List<String> listDataHeader = new ArrayList<String>();
    //HashMap<String, List<String>> listDataChild = new HashMap<String, List<String>>();
    //List<String> foodData = new ArrayList<String>();

    @Override
    protected JSONArray doInBackground(String... strings){

        af.params.add("method=foods.search");
        af.params.add("search_expression=" + af.encode(strings[0]));

        try {
            af.params.add("oauth_signature=" + af.sign(af.HTTP_METHOD, af.APP_URL, af.params.toArray(af.template)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        try {

            URL url = new URL(af.APP_URL + "?" + af.makeParam(af.params.toArray(af.template)));
            URLConnection api = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            Log.e("StringBuilder Works", "The StringBuilder works!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(api.getInputStream()));
            Log.e("BufferReader Works", "The BufferReader works!");
            while ((line = reader.readLine()) != null) builder.append(line);
            JSONObject food = new JSONObject(builder.toString());   // { first
            foods = food.getJSONObject("foods");                 // { second
            arr = foods.getJSONArray("food");

            //af.populateList(arr);
            /*HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(String.valueOf(url));
            HttpResponse response = client.execute(post);

            HttpEntity entity = response.getEntity();
            String data = EntityUtils.toString(entity);

            JSONObject food = new JSONObject(data);
            arr = food.getJSONArray("foods");*/

            /*for(int i=0; i<arr.length(); i++){
                JSONObject realObj = arr.getJSONObject(i);

                List<String> foodData = new ArrayList<String>();
                foodData.add(realObj.getString("food_description"));
                af.listDataHeader.add(realObj.getString("food_name"));
                foodData.add(realObj.getString("food_type"));

                af.listDataChild.put(af.listDataHeader.get(i),foodData);
            }

            String line;
            StringBuilder builder = new StringBuilder();
            Log.e("StringBuilder Works", "The StringBuilder works!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(api.getInputStream()));
            reader.reset();
            reader= new BufferedReader(new InputStreamReader(api.getInputStream()));
            Log.e("BufferReader Works", "The BufferReader works!");
            while ((line = reader.readLine()) != null) builder.append(line);
            JSONObject food = new JSONObject(builder.toString());   // { first
            foods = food.getJSONObject("foods");*/                    // { second
        } catch (Exception exception) {
            Log.e("FatSecret Error", exception.toString());
            exception.printStackTrace();
        }

        return arr;
    }

    protected void onPostExecute(JSONArray array){
        af.populateList(array);

        /*try{
            for(int i=0; i<array.length(); i++){
                JSONObject realObj = array.getJSONObject(i);
                List<String> foodData = new ArrayList<String>();

                foodData.add(realObj.getString("food_description"));
                af.listDataHeader.add(realObj.getString("food_name"));
                foodData.add(realObj.getString("food_type"));

                af.listDataChild.put(af.listDataHeader.get(i),foodData);
                af.listAdapter.notifyDataSetChanged();
                af.expListView.setAdapter(af.listAdapter);
            }
        }catch (Exception exception) {
            Log.e("FatSecret Error", exception.toString());
            exception.printStackTrace();
        }*/
    }
}
