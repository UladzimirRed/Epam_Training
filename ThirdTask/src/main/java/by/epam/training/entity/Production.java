package by.epam.training.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Production {
    private String manufactor;
    private String country;
    private final String DATE_PATTERN = "yyyy-MM-dd";
    private LocalDateTime foundingDate;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String value) {
        this.manufactor = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public LocalDateTime getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDateTime value) {
        this.foundingDate = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Production that = (Production) o;
        if (!manufactor.equals(that.manufactor)) return false;
        if (!country.equals(that.country)) return false;
        if (!foundingDate.equals(that.foundingDate)) return false;
        return formatter.equals(that.formatter);
    }

    @Override
    public int hashCode() {
        int result = manufactor.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + foundingDate.hashCode();
        result = 31 * result + formatter.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Production{");
        sb.append("manufactor='").append(manufactor).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", foundingDate=").append(foundingDate.format(formatter));
        sb.append('}');
        return sb.toString();
    }
}
