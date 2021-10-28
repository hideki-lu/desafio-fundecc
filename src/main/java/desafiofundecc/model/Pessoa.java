package desafiofundecc.model;

import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private Date dataNascimento;
    private Sexo sexo;
    private long cpf;
    
    public Pessoa(String nome, Date dataNascimento, Sexo sexo, long cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
    }

    public char sexoToChar() {
        switch (sexo) {
            case MASCULINO: return 'm';
            case FEMININO: return 'f';
            default: return ' ';
        }
    }

    public long getCpf() {
        return cpf;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }
    
    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }
}