package pl.javastart.lookout;

import java.security.SecureRandom;

public class Vessel {

    private String vslName;
    private Integer IMO;

    public String getVslName() {
        return vslName;
    }

    public void setVslName(String vslName) {
        this.vslName = vslName;
    }

    public Integer getIMO() {
        return IMO;
    }

    public void setIMO(Integer IMO) {
        this.IMO = IMO;
    }

    public Vessel(String vslName, Integer IMO) {
        this.vslName = vslName;
        this.IMO = IMO;

    }

    @Override
    public String toString() {
        return vslName + " "  + IMO;
    }
}
