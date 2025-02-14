package app;
import java.time.LocalDate;
public abstract class PessoaFisica {
    private String nome, cpf;
    private LocalDate dtNascimento;

    public PessoaFisica(String nome, String cpf, LocalDate dtNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }
    public abstract void mostrarHistoricoConsultas();
    public abstract void mostrarHistoricoExames();

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
