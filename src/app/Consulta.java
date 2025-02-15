package app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private LocalDateTime dataHora;
    private int duracaoMinutos;
    private String status; // AGENDADA, CANCELADA, REALIZADA
    private Paciente paciente;
    private Medico medicoResponsavel;
    private List<Exame> examesPrescritos;
    private double valor;

    public Consulta(LocalDateTime dataHora, int duracaoMinutos, Paciente paciente, Medico medico, double valor) {
        this.dataHora = dataHora;
        this.duracaoMinutos = duracaoMinutos;
        this.paciente = paciente;
        this.medicoResponsavel = medico;
        this.status = "AGENDADA";
        this.examesPrescritos = new ArrayList<>();
        this.valor = valor;
    }

    public void prescreverExame(Exame exame) {
        examesPrescritos.add(exame);
    }


    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public List<Exame> getExamesPrescritos() {
        return new ArrayList<>(examesPrescritos);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "dataHora=" + dataHora +
                ", duracaoMinutos=" + duracaoMinutos +
                ", status='" + status + '\'' +
                ", paciente=" + paciente.getNome() +
                ", medicoResponsavel=" + medicoResponsavel.getNome() +
                ", valor=" + valor +
                '}';
    }
}
