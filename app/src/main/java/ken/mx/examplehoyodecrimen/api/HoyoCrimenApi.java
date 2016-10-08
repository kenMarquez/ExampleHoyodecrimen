package ken.mx.examplehoyodecrimen.api;

import ken.mx.examplehoyodecrimen.models.sectores.SectoresResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ken on 07/10/16.
 */

public interface HoyoCrimenApi {

    @GET("/api/v1/sectores/geojson")
    Call<SectoresResponse> getSectores();

    @GET("/api/v1/sectores/geojson")
    Call<ResponseBody> getSectores2();
}
