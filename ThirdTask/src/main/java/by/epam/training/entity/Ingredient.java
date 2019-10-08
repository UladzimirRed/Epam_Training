package by.epam.training.entity;

public class Ingredient {

    private double water;
    private double sugar;
    private double vanillin;

    public Ingredient(double water, double sugar, double vanillin) {
        this.water = water;
        this.sugar = sugar;
        this.vanillin = vanillin;
    }

    public Ingredient() {
    }

    public double getWater() {
        return water;
    }

    public void setWater(double value) {
        this.water = value;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double value) {
        this.sugar = value;
    }

    public double getVanillin() {
        return vanillin;
    }

    public void setVanillin(double value) {
        this.vanillin = value;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredients{");
        sb.append("water=").append(water);
        sb.append(", sugar=").append(sugar);
        sb.append(", vanillin=").append(vanillin);
        sb.append('}');
        return sb.toString();
    }
}
