package desafiofundecc.controller.csvstorage;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import desafiofundecc.controller.storageinterfaces.StorageHandler;

public class CsvFileStorage<T extends CsvStringable<T>> implements StorageHandler<T> {
    private String path;
    private List<T> collection;
    private List<String[]> csvCollection;
    public CsvFileStorage(String path) {
        this.path = path;
        collection = new ArrayList<T>();
        csvCollection = new ArrayList<String[]>();
    }

    private CsvFileStorage(String path, List<T> collection, List<String[]> csvCollection) {
        this.path = path;
        this.collection = new ArrayList<T>(collection);
        this.csvCollection = new ArrayList<String[]>(csvCollection);
    }

    public CsvFileStorage<T> addCollection(List<T> collection) {
        return new CsvFileStorage<T>(this.path, collection, this.csvCollection);
    }

    public CsvFileStorage<T> loadCSVRecords() {
        try { read();
              return new CsvFileStorage<T>(this.path, this.collection, this.csvCollection); }
        catch (IOException exception)  {
                System.err.println("A error ocurred on try to load file: " 
                                   + path + "\n" + exception.getMessage()); 
                return new CsvFileStorage<T>(this.path, this.collection, this.csvCollection);
        }
    }
    public List<String[]> getCsvCollection() {
        return csvCollection;
    }

    @Override
    public void read() throws IOException {
        ObjectInputStream inputStream = null;
        try {
            var reader = new CSVReader(new FileReader(path));
            String[] record = null;
            while ((record = reader.readNext()) != null) {
                csvCollection.add(record);
            }
            
        } catch (IOException | CsvValidationException exception) {
            throw new IOException("Error while reading the data.");
        } finally {
            if (inputStream != null) {
                try { inputStream.close(); } 
                catch (IOException exception) 
                    { throw new IOException("Error while closing file.");}
            }
        }
    }

    @Override
    public void save() throws IOException {
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(Path.of(path));
            for (var data: collection)
                writer.write(data.toCsvString());
        } catch(IOException exception) {
            throw (new IOException("Fail while saving the data."));
        } finally {
            if (writer != null) {
                try { writer.close(); }
                catch(IOException exception) 
                    { throw new IOException("Fail while closing file: " + path); }
            }
        }
        
    }

}