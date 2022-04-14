package exercise;

public class Cup {
    private String liquidType;
    private double percentFull;

    public String getLiquidType() {
        return liquidType;
    }

    public void setLiquidType(String liquidType) {
        this.liquidType = liquidType;
    }

    public double getPercentFull() {
        return percentFull;
    }

    public void setPercentFull(double percentFull) {
        this.percentFull = percentFull;
    }

    public Cup(String liquidType, double percentFull) {
        this.liquidType = liquidType;
        this.percentFull = percentFull;
    }

}
