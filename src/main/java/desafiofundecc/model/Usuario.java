package desafiofundecc.model;

import desafiofundecc.controller.CsvStringable;

public final class Usuario extends Pessoa implements CsvStringable<Usuario> {
    private Cargo cargo;
    
    public Usuario(String nome, String dataNascimento, long cpf, Sexo sexo, Cargo cargo) {
        super (nome, dataNascimento, sexo, cpf);
        this.cargo = cargo;
    }

    @Override
    public String toCsvString() {
        return getNome() + "," + 
               getDataNascimento() + "," +
               getCpf() + "," +
               Sexo.sexoToChar(getSexo()) + "," +
               cargo.getName() + "\n";
    }
    public Usuario fromCVSToUser(String[] record) {
        return new Usuario (
            record[0],
            record[1],
            Long.parseLong(record[2]),
            Sexo.charToSexo(record[3].charAt(0)),
            new Cargo(record[4])
        );
    }
    
    public Cargo getCargo() {
        return cargo;
    }

    @Override
    public long getCpf() {
        return getCpf();
    }

    @Override
    public String getDataNascimento() {
        return getDataNascimento();
    }

    @Override
    public String getNome() {
        return getNome();
    }

    @Override
    public Sexo getSexo() {
        return getSexo();
    }
}