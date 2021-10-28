package desafiofundecc.controller;

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

public class CsvFileStorage<T extends CsvStringable<T>> implements StorageHandler<T> {
    private String path;
    private List<T> collection;
    private List<String[]> csvCollection;
    public CsvFileStorage(String path) {
        this.path = path;
        collection = new ArrayList<T>();
        csvCollection = new ArrayList<String[]>();
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
                try { inputStream.close(); 
                } catch(IOException exception) 
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