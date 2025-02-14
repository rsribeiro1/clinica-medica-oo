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
    private List<Medicamento> medicamentosPrescritos;
    private double valor;

    public Consulta(LocalDateTime dataHora, int duracaoMinutos, Paciente paciente, Medico medico, double valor) {
        this.dataHora = dataHora;
        this.duracaoMinutos = duracaoMinutos;
        this.paciente = paciente;
        this.medicoResponsavel = medico;
        this.status = "AGENDADA";
        this.examesPrescritos = new ArrayList<>();
        this.medicamentosPrescritos = new ArrayList<>();
        this.valor = valor;
    }

    public void prescreverExame(Exame exame) {
        examesPrescritos.add(exame);
    }

    public void prescreverMedicamento(Medicamento medicamento) {
        medicamentosPrescritos.add(medicamento);
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
        return new ArrayList<>(examesPrescritos); // Passando copia por questoes de seguranca
    }

    public void setExamesPrescritos(List<Exame> examesPrescritos) {
        this.examesPrescritos = examesPrescritos;
    }

    public List<Medicamento> getMedicamentosPrescritos() {
        return new ArrayList<>(medicamentosPrescritos); // Passando copia por questoes de seguranca
    }

    public void setMedicamentosPrescritos(List<Medicamento> medicamentosPrescritos) {
        this.medicamentosPrescritos = medicamentosPrescritos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
