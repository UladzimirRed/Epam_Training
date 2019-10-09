package by.epam.training.entity;

public class Ingredient {
    private String unit;
    private double water;
    private double sugar;
    private double vanillin;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getVanillin() {
        return vanillin;
    }

    public void setVanillin(double vanillin) {
        this.vanillin = vanillin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        if (Double.compare(that.water, water) != 0) return false;
        if (Double.compare(that.sugar, sugar) != 0) return false;
        if (Double.compare(that.vanillin, vanillin) != 0) return false;
        return unit != null ? unit.equals(that.unit) : that.unit == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = unit != null ? unit.hashCode() : 0;
        temp = Double.doubleToLongBits(water);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sugar);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(vanillin);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredient{");
        sb.append("water=").append(water).append(unit);
        sb.append(", sugar=").append(sugar).append(unit);
        sb.append(", vanillin=").append(vanillin).append(unit);
        sb.append('}');
        return sb.toString();
    }
}
