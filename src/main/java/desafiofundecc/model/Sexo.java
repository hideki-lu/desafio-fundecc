package desafiofundecc.model;

public enum Sexo {
    MASCULINO, FEMININO, NAO_DEFINIDO;
    public static char sexoToChar(Sexo sexo) {
        switch (sexo) {
            case MASCULINO: return 'm';
            case FEMININO: return 'f';
            default: return ' ';
        }
    }

    public static Sexo charToSexo(char character) {
        switch (Character.toLowerCase(character)) {
            case 'm': return MASCULINO;
            case 'f': return FEMININO;
            default: return NAO_DEFINIDO;
        }
    }
}