package by.epam.training.entity;

public class CandyKind {

    private KindsOfCandies type;
    private boolean stuffed;

    public CandyKind() {
    }

    public CandyKind(KindsOfCandies type, boolean stuffed) {
        this.type = type;
        this.stuffed = stuffed;
    }

    public KindsOfCandies getType() {
        return type;
    }
    public void setType(KindsOfCandies value) {
        this.type = value;
    }
    public boolean isStuffed() {
        return stuffed;
    }

    public void setStuffed(boolean value) {
        this.stuffed = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CandyKind{");
        sb.append("type=").append(type);
        sb.append(", stuffed=").append(stuffed);
        sb.append('}');
        return sb.toString();
    }
}
