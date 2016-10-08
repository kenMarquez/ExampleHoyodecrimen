
package ken.mx.examplehoyodecrimen.models.sectores;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SectoresResponse {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<Feature> features = new ArrayList<Feature>();

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
     * @return The features
     */
    public List<Feature> getFeatures() {
        return features;
    }

    /**
     * @param features The features
     */
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "SectoresResponse{" +
                "type='" + type + '\'' +
                ", features=" + features +
                '}';
    }
}
