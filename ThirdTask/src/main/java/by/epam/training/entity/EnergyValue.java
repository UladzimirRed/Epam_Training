package by.epam.training.entity;

public class EnergyValue {

    private double proteins;
    private double fats;
    private double carbohydrates;

    public EnergyValue(double proteins, double fats, double carbohydrates) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public EnergyValue() {
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double value) {
        this.proteins = value;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double value) {
        this.fats = value;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double value) {
        this.carbohydrates = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EnergyValue{");
        sb.append("proteins=").append(proteins);
        sb.append(", fats=").append(fats);
        sb.append(", carbohydrates=").append(carbohydrates);
        sb.append('}');
        return sb.toString();
    }
}
