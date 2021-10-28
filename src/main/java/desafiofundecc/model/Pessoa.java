package desafiofundecc.model;


public abstract class Pessoa {
    private String nome;
    private String dataNascimento;
    private Sexo sexo;
    private long cpf;
    
    public Pessoa(String nome, String dataNascimento, Sexo sexo, long cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.cpf = cpf;
    }



    public long getCpf() {
        return cpf;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public String getNome() {
        return nome;
    }

    public Sexo getSexo() {
        return sexo;
    }
}