package by.epam.training.entity;

public class Candy {
    private String title;
    private int energy;
    private CandyKind candyKind = new CandyKind();
    private Ingredient ingredient = new Ingredient();
    private EnergyValue energyValue = new EnergyValue();
    private Production production = new Production();
    private String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int value) {
        this.energy = value;
    }

    public CandyKind getKind() {
        return candyKind;
    }

    public void setKind(CandyKind value) {
        this.candyKind = value;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient value) {
        this.ingredient = value;
    }

    public EnergyValue getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(EnergyValue value) {
        this.energyValue = value;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production value) {
        this.production = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        if (energy != candy.energy) return false;
        if (!title.equals(candy.title)) return false;
        if (!candyKind.equals(candy.candyKind)) return false;
        if (!ingredient.equals(candy.ingredient)) return false;
        if (!energyValue.equals(candy.energyValue)) return false;
        if (!production.equals(candy.production)) return false;
        return id.equals(candy.id);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + energy;
        result = 31 * result + candyKind.hashCode();
        result = 31 * result + ingredient.hashCode();
        result = 31 * result + energyValue.hashCode();
        result = 31 * result + production.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Candy{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", energy=").append(energy);
        sb.append(", ").append(candyKind);
        sb.append(", ").append(ingredient);
        sb.append(", ").append(energyValue);
        sb.append(", ").append(production);
        sb.append('}');
        return sb.toString();
    }
}
