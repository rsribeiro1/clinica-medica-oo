package app;
import java.time.LocalDate;
import java.util.ArrayList;
import  java.util.List;

public class Medico extends PessoaFisica {
    private String crm, especialidade;
    private List<Consulta> consultas;
    private List<Exame> examesPrescritos;

    public Medico(String nome, String cpf, LocalDate dtNascimento, String crm, String especialidade) {
        super(nome, cpf, dtNascimento);
        this.crm = crm;
        this.especialidade = especialidade;
        this.consultas = new ArrayList<>();
        this.examesPrescritos = new ArrayList<>();
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Consulta> getConsultasAgendadas() {
        return new ArrayList<>(consultas);
    }
    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }
    public void adicionarExame(Exame exame){
        examesPrescritos.add(exame);
    }
}
