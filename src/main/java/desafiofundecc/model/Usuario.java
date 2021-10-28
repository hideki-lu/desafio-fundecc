package desafiofundecc.model;

import java.util.Date;

import desafiofundecc.controller.CsvStringable;

public final class Usuario extends Pessoa implements CsvStringable {
    private Cargo cargo;
    
    public Usuario(String nome, Date dataNascimento, long cpf, Sexo sexo, Cargo cargo) {
        super (nome, dataNascimento, sexo, cpf);
        this.cargo = cargo;
    }

    @Override
    public String toCsvString() {
        return getNome() + "," + 
               getDataNascimento().toString() + "," +
               getCpf() + "," +
               sexoToChar() + "," +
               cargo.getName() + "\n";
    }
    
    @Override
    public char sexoToChar() {
        return super.sexoToChar();
    }
    
    public Cargo getCargo() {
        return cargo;
    }

    @Override
    public long getCpf() {
        return super.getCpf();
    }

    @Override
    public Date getDataNascimento() {
        return super.getDataNascimento();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public Sexo getSexo() {
        return super.getSexo();
    }
}