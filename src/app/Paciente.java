package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends PessoaFisica {
    private List<Consulta> historicoConsultas;
    private List<Exame> historicoExames;

    public Paciente(String nome, String cpf, LocalDate dtNascimento, List<Consulta> historicoConsultas, List<Exame> historicoExames) {
        super(nome, cpf, dtNascimento);
        this.historicoConsultas = new ArrayList<>();
        this.historicoExames = new ArrayList<>();
    }

    public void adicionarConsultas(Consulta consulta){
        historicoConsultas.add(consulta);
    }
    public void adicionarExame(Exame exame){
        historicoExames.add(exame);
    }
    public void mostrarHistoricoConsultas() {
        if (historicoConsultas.isEmpty()) {
            System.out.println("Nenhuma consulta registrada para o paciente " + this.getNome() + ".");
            return;
        }
        int i = 0;
        System.out.println("\n--- Histórico de consultas de " + this.getNome() + " ---");
        for (Consulta consulta : historicoConsultas) {
            System.out.println("Indice " + i);
            System.out.println("Data: " + consulta.getDataHora().toLocalDate());
            System.out.println("Horário: " + consulta.getDataHora().toLocalTime());
            System.out.println("Médico: " + consulta.getMedicoResponsavel().getNome());
            System.out.println("Status: " + consulta.getStatus());
            System.out.println("Valor: R$ " + consulta.getValor());
            System.out.println("------------------------------");
            i++;
        }
    }
    public void mostrarHistoricoExames() {
        if (historicoConsultas.isEmpty()) {
            System.out.println("Nenhum exame registrado para o paciente " + this.getNome() + ".");
            return;
        }
        int i = 0;
        System.out.println("\n--- Histórico de exames de " + this.getNome() + " ---");
        for (Exame exame : historicoExames) {
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

