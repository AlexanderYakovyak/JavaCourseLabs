package media;

public class Catalog {

    int id;
    String industry;
    String copyrights;
    long items_number;


    public Catalog(int id, String industry, String copyrights, long items_number) {
        this.id = id;
        this.industry = industry;
        this.copyrights = copyrights;
        this.items_number = items_number;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "industry='" + industry + '\'' +
                ", copyrights='" + copyrights + '\'' +
                ", items_number=" + items_number +
                '}';
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

