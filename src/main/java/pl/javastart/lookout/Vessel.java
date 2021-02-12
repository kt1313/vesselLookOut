package pl.javastart.lookout;

import java.security.SecureRandom;

public class Vessel {

    private String vslName;
    private String vslCallSign;
    private Integer MMSI;
    private Integer IMO;

    public String getVslName() {
        return vslName;
    }

    public void setVslName(String vslName) {
        this.vslName = vslName;
    }

    public String getVslCallSign() {
        return vslCallSign;
    }

    public void setVslCallSign(String vslCallSign) {
        this.vslCallSign = vslCallSign;
    }

    public Integer getMMSI() {
        return MMSI;
    }

    public void setMMSI(Integer MMSI) {
        this.MMSI = MMSI;
    }

    public Integer getIMO() {
        return IMO;
    }

    public void setIMO(Integer IMO) {
        this.IMO = IMO;
    }

    public Vessel(String vslName, String vslCallSign, Integer MMSI, Integer IMO){
        this.vslName=vslName;
        this.vslCallSign=vslCallSign;
        this.MMSI=MMSI;
        this.IMO=IMO;

    }

}
