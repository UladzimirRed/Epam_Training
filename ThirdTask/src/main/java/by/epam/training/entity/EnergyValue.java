package by.epam.training.entity;

public class EnergyValue {
    private double proteins;
    private double fats;
    private double carbohydrates;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnergyValue that = (EnergyValue) o;
        if (Double.compare(that.proteins, proteins) != 0) return false;
        if (Double.compare(that.fats, fats) != 0) return false;
        return Double.compare(that.carbohydrates, carbohydrates) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(proteins);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fats);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(carbohydrates);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
