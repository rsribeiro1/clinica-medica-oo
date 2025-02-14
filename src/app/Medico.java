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
        return new ArrayList<>(consultas); // Passando copia por questoes de seguranca
    }
    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void adicionarConsultas(Consulta consulta){
        consultas.add(consulta);
    }
    public void adicionarExame(Exame exame){
        examesPrescritos.add(exame);
    }
    public void mostrarHistoricoConsultas(){
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta registrada para o medico " + this.getNome() + ".");
            return;
        }
        int i = 0;
        System.out.println("\n--- Histórico de consultas de " + this.getNome() + " ---");
        for (Consulta consulta : consultas) {
            System.out.println("Indice " + i);
            System.out.println("Data: " + consulta.getDataHora().toLocalDate());
            System.out.println("Horário: " + consulta.getDataHora().toLocalTime());
            System.out.println("Paciente: " + consulta.getPaciente().getNome());
            System.out.println("Status: " + consulta.getStatus());
            System.out.println("Valor: R$ " + consulta.getValor());
            System.out.println("------------------------------");
            i++;
        }
    }
    public void mostrarHistoricoExames() {
        if (examesPrescritos.isEmpty()) {
            System.out.println("Nenhum exame registrado para o medico " + this.getNome() + ".");
            return;
        }
        int i = 0;
        System.out.println("\n--- Histórico de exames prescritos por " + this.getNome() + " ---");
        for (Exame exame : examesPrescritos) {
            System.out.println("Indice " + i);
            System.out.println("Tipo: " + exame.getTipo());
            System.out.println("Data de prescricao " + exame.getDataPrescricao());
            System.out.println("Data de realizacao " + exame.getDataRealizacao());
            System.out.println("Resultado " + exame.getResultado());
            System.out.println("Custo: R$ " + exame.getCusto());
            System.out.println("------------------------------");
            i++;
        }
    }
}
