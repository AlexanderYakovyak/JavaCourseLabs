package media;

public class Subcatalog {

    int id;
    Catalog catalog;
    String industry;
    String copyrights;
    long items_number;

    public Subcatalog(int id, Catalog catalog, String industry, String copyrights, long items_number) {
        this.id = id;
        this.catalog = catalog;
        this.industry = industry;
        this.copyrights = copyrights;
        this.items_number = items_number;
    }

    @Override
    public String toString() {
        return "Subcatalog{" +
                "catalog=" + catalog.industry +
                ", industry='" + industry + '\'' +
                ", copyrights='" + copyrights + '\'' +
                ", items_number=" + items_number +
                '}';
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public long getItems_number() {
        return items_number;
    }

    public void setItems_number(long items_number) {
        this.items_number = items_number;
    }
}
