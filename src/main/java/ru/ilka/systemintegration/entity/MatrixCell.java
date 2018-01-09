package ru.ilka.systemintegration.entity;

public class MatrixCell {
    private Coordinates coordinates;
    private String displayedInfo;

    public MatrixCell() {
        displayedInfo = "   ";
    }

    public MatrixCell(int x, int y, String displayedInfo) {
        this.coordinates = new Coordinates(x, y);
        this.displayedInfo = displayedInfo;
    }

    public MatrixCell(Coordinates coordinates, String displayedInfo) {
        this.coordinates = coordinates;
        this.displayedInfo = displayedInfo;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getDisplayedInfo() {
        return displayedInfo;
    }

    public void setDisplayedInfo(String displayedInfo) {
        this.displayedInfo = displayedInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatrixCell that = (MatrixCell) o;

        if (!coordinates.equals(that.coordinates)) return false;
        return displayedInfo.equals(that.displayedInfo);
    }

    @Override
    public int hashCode() {
        int result = coordinates.hashCode();
        result = 31 * result + displayedInfo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MatrixCell{" +
                "coordinates=" + coordinates +
                ", displayedInfo='" + displayedInfo + '\'' +
                '}';
    }
}
