package desafiofundecc.controller;

import java.io.IOException;
import java.util.Optional;

public interface StorageHandler<T> {
    public void save(T type) throws IOException;
    public Optional<T> get();
}