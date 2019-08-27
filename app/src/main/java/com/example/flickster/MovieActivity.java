package com.example.flickster;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flickster.models.Movie;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MovieActivity extends AppCompatActivity {

    private static final  String MOVIE_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

    List<Movie> movies;

    //Add RecyclerView support library to the Gradle build file- DONE
    //Define a model class to use as the data source-DONE
    //Add a RecyclerView to your activity to display the items-DONE
    //Create a custom row layout XML file to visualize the item-DONE
    //Create a RecyclerView.Adapter and ViewHolder to render the item
    //Bind the adapter to the data source to populate the RecyclerView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(MOVIE_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode,Header[] headers,JSONObject response) {
                try {
                    JSONArray movieJsonArray = response.getJSONArray("results");
                    //fromJsonArray
                    //movies = com.example.Flickster.models.Movie.fromJsonArray(movieJsonArray) ;
                    movies = Movie.fromJsonArray(movieJsonArray);
                    Log.d("smile", movieJsonArray.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode,Header[] headers,String responseString,Throwable throwable) {
                super.onFailure(statusCode,headers,responseString,throwable);
            }
        });
    }
}
