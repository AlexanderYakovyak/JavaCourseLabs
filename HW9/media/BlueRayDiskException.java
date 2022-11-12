package media;

class BlueRayDiskException extends ArithmeticException{
    private String message;

    BlueRayDiskException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

class CatalogException extends ArithmeticException {
    private final int catalog_id;

    CatalogException(int catalog_id){
        this.catalog_id = catalog_id;
    }

    @Override
    public String toString() {
        return String.format("No catalog with such id: %d", this.catalog_id);
    }
}

class SubcatalogException extends ArithmeticException {
    private final int subcatalog_id;

    SubcatalogException(int subcatalog_id){
        this.subcatalog_id = subcatalog_id;
    }

    @Override
    public String toString() {
        return String.format("No subcatalog with such id: %d", this.subcatalog_id);
    }
}

class RecordException extends ArithmeticException {
    private int record_id;

    RecordException(int record_id){
        this.record_id = record_id;
    }

    @Override
    public String toString() {
        return String.format("No record with such id: %d", this.record_id);
    }
}
