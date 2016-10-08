
package ken.mx.examplehoyodecrimen.models.sectores;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Geometry {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("coordinates")
    @Expose
    private List<List<List<Double>>> coordinates = new ArrayList<List<List<Double>>>();

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The coordinates
     */
    public List<List<List<Double>>> getCoordinates() {
        return coordinates;
    }

    /**
     * @param coordinates The coordinates
     */
    public void setCoordinates(List<List<List<Double>>> coordinates) {
        this.coordinates = coordinates;
    }


    @Override
    public String toString() {
        return "Geometry{" +
                "type='" + type + '\'' +
                '}';
    }
}
