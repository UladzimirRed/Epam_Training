package by.epam.training.entity;

public class CandyKind {
    private KindsOfCandies type;
    private boolean stuffed;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyKind candyKind = (CandyKind) o;
        if (stuffed != candyKind.stuffed) return false;
        return type == candyKind.type;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (stuffed ? 1 : 0);
        return result;
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
