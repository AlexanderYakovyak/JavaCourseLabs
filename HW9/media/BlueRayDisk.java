package media;

import java.util.ArrayList;
import java.util.List;

public class BlueRayDisk {

    private static class Storage{
        List<Catalog> catalogs = new ArrayList<>();
        List<Subcatalog> subcats = new ArrayList<>();
        List<Record> records = new ArrayList<>();

        Catalog getCatalog(int catalog_id){
            boolean found = false;
            for(Catalog catalog: this.catalogs){
                if(catalog.id == catalog_id){
                    return catalog;
                }
            }

            if (!found) {
                throw new CatalogException(catalog_id);
            }

            return null;
        }

        Subcatalog getSubcatalog(int subcatalog_id){
            boolean found = false;

            for(Subcatalog subcatalog: this.subcats){
                if(subcatalog.id == subcatalog_id){
                    return subcatalog;
                }
            }

            if (!found) {
                throw new SubcatalogException(subcatalog_id);
            }

            return null;
        }

        Record getRecord(int record_id){
            boolean found = false;

            for(Record record: this.records){
                if(record.id == record_id){
                    return record;
                }
            }
            if (!found) {
                throw new RecordException(record_id);
            }

            return null;
        }

        void addCatalog(Catalog catalog){
            this.catalogs.add(catalog);
        }

        void addSubcatalog(Subcatalog subcatalog){
            this.subcats.add(subcatalog);
        }

        void addRecord(Record record){
            this.records.add(record);
        }

    }

    String title;
    String encoding;
    int release_year;
    Storage storage;

    public BlueRayDisk(String title, String encoding, int release_year) {
        this.title = title;
        this.encoding = encoding;
        this.release_year = release_year;
        this.storage = new BlueRayDisk.Storage();
    }

    public static void main(String args[]){
        Catalog catalog1 = new Catalog(1, "music", "Warner Records", 100000);
        Subcatalog subcatalog1 = new Subcatalog(1, catalog1, "Hip-hop", "Warner Records", 12445);
        Record record1 = new Record(1, catalog1, subcatalog1, "Warner Records", "Warner Records", "Kanye West","Stronger", 248.0);

        BlueRayDisk disk = new BlueRayDisk("Kanye West - Stronger - Musical Video", "H.262/MPEG-2 Part 2", 2007);
        disk.storage.addCatalog(catalog1);
        disk.storage.addSubcatalog(subcatalog1);
        disk.storage.addRecord(record1);

        System.out.println("\nRecord you are looking for: ");
        Record new_record = disk.storage.getRecord(1);
        System.out.println(new_record);

        System.out.println("\nEverything seems okay, but... \n");

        Record new_record2 = disk.storage.getRecord(2);
        System.out.println(new_record2);



    }


}
