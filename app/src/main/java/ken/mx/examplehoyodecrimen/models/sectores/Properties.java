
package ken.mx.examplehoyodecrimen.models.sectores;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Properties {

    @SerializedName("sector")
    @Expose
    private String sector;
    @SerializedName("cve_mun")
    @Expose
    private String cveMun;
    @SerializedName("municipio")
    @Expose
    private String municipio;

    /**
     * @return The sector
     */
    public String getSector() {
        return sector;
    }

    /**
     * @param sector The sector
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * @return The cveMun
     */
    public String getCveMun() {
        return cveMun;
    }

    /**
     * @param cveMun The cve_mun
     */
    public void setCveMun(String cveMun) {
        this.cveMun = cveMun;
    }

    /**
     * @return The municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio The municipio
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "sector='" + sector + '\'' +
                ", cveMun='" + cveMun + '\'' +
                ", municipio='" + municipio + '\'' +
                '}';
    }
}
