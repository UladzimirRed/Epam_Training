package by.epam.training.entity;

public class Candy {

    private String name;
    private int energy;
    private CandyKind candyKind = new CandyKind();
    private Ingredients ingredients = new Ingredients();
    private EnergyValue energyValue = new EnergyValue();
    private Production production = new Production();
    private String id;

    public Candy() {
    }

    public Candy(String name, int energy, CandyKind candyKind, Ingredients ingredients,
                 EnergyValue energyValue, Production production, String id) {
        this.name = name;
        this.energy = energy;
        this.candyKind = candyKind;
        this.ingredients = ingredients;
        this.energyValue = energyValue;
        this.production = production;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
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
    public Ingredients getIngredients() {
        return ingredients;
    }
    public void setIngredients(Ingredients value) {
        this.ingredients = value;
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("Candy{");
        sb.append("name='").append(name).append('\'');
        sb.append(", energy=").append(energy);
        sb.append(", candyKind=").append(candyKind);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", energyValue=").append(energyValue);
        sb.append(", production=").append(production);
        sb.append(", id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
