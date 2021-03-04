package pl.javastart.lookout;

public class Vessel {

    private String vslName;
    private Integer nrIMO;

    public String getVslName() {
        return vslName;
    }

    public void setVslName(String vslName) {
        this.vslName = vslName;
    }

    public Integer getNrIMO() {
        return nrIMO;
    }

    public void setNrIMO(Integer nrIMO) {
        this.nrIMO = nrIMO;
    }

    public Vessel(String vslName, Integer nrIMO) {
        this.vslName = vslName;
        this.nrIMO = nrIMO;

    }

    @Override
    public String toString() {
        return vslName + " "  + nrIMO;
    }
}
