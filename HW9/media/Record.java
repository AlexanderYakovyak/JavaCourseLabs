package media;

public class Record {
    int id;
    Catalog catalog;
    Subcatalog subcat;
    String label;
    String copyrights;
    String composer;
    String title;
    double duration;

    public Record(int id, Catalog catalog, Subcatalog subcat, String label, String copyrights, String composer, String title, double duration) {
        this.id = id;
        this.catalog = catalog;
        this.subcat = subcat;
        this.label = label;
        this.copyrights = copyrights;
        this.composer = composer;
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Record{" +
                "catalog=" + catalog.industry +
                ", subcat=" + subcat.industry +
                ", label='" + label + '\'' +
                ", copyrights='" + copyrights + '\'' +
                ", composer='" + composer + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Subcatalog getSubcat() {
        return subcat;
    }

    public void setSubcat(Subcatalog subcat) {
        this.subcat = subcat;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
