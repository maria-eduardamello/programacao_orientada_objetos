
public class Titular {

    private String nome;
    private String cpf;
    private String dataNascimento;

    Titular(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getTitular() {
        return nome;
    }

    public void setTitular(String novo) {
        if (novo != null && !novo.trim().isEmpty()) {
            this.nome = novo;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
}

