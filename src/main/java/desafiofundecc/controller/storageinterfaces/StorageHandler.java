package desafiofundecc.controller.storageinterfaces;

import java.io.IOException;

public interface StorageHandler<T> {
    public void save() throws IOException;
    public void read() throws IOException;
}