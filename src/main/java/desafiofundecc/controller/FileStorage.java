package desafiofundecc.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileStorage<T> implements StorageHandler<T> {
    private String path;
    private List<T> collection;
    public FileStorage(String path) {
        this.path = path;
        collection = new ArrayList<T>();
    }

    @Override
    public Optional<T> get() {
        
        return null;
    }

    @Override
    public void save(T type) throws IOException {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(path));
            outputStream.writeObject(type);
        } catch(IOException exception) {
            throw (new IOException("Fail while saving the data: " + type.toString()));
        } finally {
            if (outputStream != null) {
                try { outputStream.close(); }
                catch(IOException exception) 
                    { throw new IOException("Fail while closing file: " + path); }
            }
        }
        
    }

}