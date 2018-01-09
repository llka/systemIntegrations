package ru.ilka.systemintegration.entity;

public class Integration {
    private String fromProjectSystemId;
    private String toProjectSystemId;
    private String integrationDocsUrl;

    public Integration() {
    }

    public Integration(String from, String to) {
        this.fromProjectSystemId = from;
        this.toProjectSystemId = to;
    }

    public Integration(String fromProjectSystemId, String toProjectSystemId, String integrationDocsUrl) {
        this.fromProjectSystemId = fromProjectSystemId;
        this.toProjectSystemId = toProjectSystemId;
        this.integrationDocsUrl = integrationDocsUrl;
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

    public String getIntegrationDocsUrl() {
        return integrationDocsUrl;
    }

    public void setIntegrationDocsUrl(String integrationDocsUrl) {
        this.integrationDocsUrl = integrationDocsUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Integration that = (Integration) o;

        if (!fromProjectSystemId.equals(that.fromProjectSystemId)) return false;
        if (!toProjectSystemId.equals(that.toProjectSystemId)) return false;
        return integrationDocsUrl.equals(that.integrationDocsUrl);
    }

    @Override
    public int hashCode() {
        int result = fromProjectSystemId.hashCode();
        result = 31 * result + toProjectSystemId.hashCode();
        result = 31 * result + integrationDocsUrl.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Integration{" +
                "fromProjectSystemId='" + fromProjectSystemId + '\'' +
                ", toProjectSystemId='" + toProjectSystemId + '\'' +
                ", integrationDocsUrl='" + integrationDocsUrl + '\'' +
                '}';
    }
}
