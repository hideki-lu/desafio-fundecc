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

public class FileStorage<T extends CsvStringable> implements StorageHandler<T> {
    private String path;
    private List<T> collection;
    public FileStorage(String path) {
        this.path = path;
        collection = new ArrayList<T>();
    }

    @Override
    public void read() throws IOException {
        ObjectInputStream inputStream = null;
        try {
            var csvStream = new CSVReader(new FileReader(path));
            String[] line;
            while ((line = csvStream.readNext()) != null) {
                System.out.println("Country id= " + line[0] + ", code= " + line[1] + " , name=" + line[2]);
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