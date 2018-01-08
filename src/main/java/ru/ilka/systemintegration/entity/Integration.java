package ru.ilka.systemintegration.entity;

public class Integration {
    private String fromProjectSystemId;
    private String toProjectSystemId;

    public Integration() {
    }

    public Integration(String from, String to) {
        this.fromProjectSystemId = from;
        this.toProjectSystemId = to;
    }

    public String getFromProjectSystemId() {
        return fromProjectSystemId;
    }

    public void setFromProjectSystemId(String fromProjectSystemId) {
        this.fromProjectSystemId = fromProjectSystemId;
    }

    public String getToProjectSystemId() {
        return toProjectSystemId;
    }

    public void setToProjectSystemId(String toProjectSystemId) {
        this.toProjectSystemId = toProjectSystemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Integration that = (Integration) o;

        if (!fromProjectSystemId.equals(that.fromProjectSystemId)) return false;
        return toProjectSystemId.equals(that.toProjectSystemId);
    }

    @Override
    public int hashCode() {
        int result = fromProjectSystemId.hashCode();
        result = 31 * result + toProjectSystemId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Integration{" +
                "from='" + fromProjectSystemId + '\'' +
                ", to='" + toProjectSystemId + '\'' +
                '}';
    }
}
