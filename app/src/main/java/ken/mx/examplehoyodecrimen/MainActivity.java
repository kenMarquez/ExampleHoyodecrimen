package ken.mx.examplehoyodecrimen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ken.mx.examplehoyodecrimen.api.HoyoCrimenApi;
import ken.mx.examplehoyodecrimen.models.sectores.SectoresResponse;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSectores();
    }

    public void getSectores() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging);

        Retrofit.Builder builder = new Retrofit.Builder()

                .baseUrl("https://hoyodecrimen.com");

        OkHttpClient client = httpClient.build();


        Retrofit retrofit = builder
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HoyoCrimenApi service = retrofit.create(HoyoCrimenApi.class);

        service.getSectores2().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    List<LatLng> latlngs = new ArrayList<>();
                    List<List<LatLng>> latlngSectores = new ArrayList<List<LatLng>>();

                    String jsonString = response.body().string();
                    JSONObject object = new JSONObject(jsonString);
                    JSONArray features = object.getJSONArray("features");
                    JSONObject feature = features.getJSONObject(0);
                    JSONObject geometry = feature.getJSONObject("geometry");
                    JSONArray coordinates = geometry.getJSONArray("coordinates");
                    for (int i = 0; i < coordinates.length(); i++) {
                        JSONArray coordinate = coordinates.getJSONArray(i);
                        List<LatLng> sectores = new ArrayList<>();

                        for (int j = 0; j < coordinate.length(); j++) {
                            JSONArray coordinateIndex = coordinate.getJSONArray(j);
                            double lon = coordinateIndex.getDouble(0);
                            double lat = coordinateIndex.getDouble(1);
                            LatLng latlng = new LatLng(lat, lon);
                            latlngs.add(latlng);
                            sectores.add(latlng);
//                            Log.d("myLog", "lat: " + lat + " lon: " + lon);
                        }

                        latlngSectores.add(sectores);


                    }


                    for (int i = 0; i < latlngSectores.size(); i++) {
                        Log.d("myLog", "-----------------------------");
                        for (int j = 0; j < latlngSectores.get(i).size(); j++) {
                            Log.d("myLog", latlngSectores.get(i).get(j).toString());
                        }

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


}
