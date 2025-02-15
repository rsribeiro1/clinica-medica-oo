package servicos;

import app.Exame;
import app.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class ServicoPaciente {
    private List<Paciente> pacientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarPaciente() {
        System.out.println("\n--- Cadastro de Paciente ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        LocalDate dtNascimento = LocalDate.parse(scanner.nextLine());

        Paciente paciente = new Paciente(nome, cpf, dtNascimento);
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }
    public void listarExamesDoPaciente(String cpf) {
        Paciente paciente = pacientes.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);

        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        List<Exame> exames = paciente.getHistoricoExames();
        if (exames.isEmpty()) {
            System.out.println("Nenhum exame registrado para o paciente " + paciente.getNome() + ".");
            return;
        }

        System.out.println("\n--- Exames do Paciente " + paciente.getNome() + " ---");
        for (int i = 0; i < exames.size(); i++) {
            Exame exame = exames.get(i);
            System.out.println("Índice: " + i);
            System.out.println("Tipo: " + exame.getTipo());
            System.out.println("Data de Prescrição: " + exame.getDataPrescricao());
            System.out.println("Data de Realização: " + (exame.getDataRealizacao() != null ? exame.getDataRealizacao() : "Não realizado"));
            System.out.println("Resultado: " + (exame.getResultado() != null ? exame.getResultado() : "N/A"));
            System.out.println("Custo: R$ " + exame.getCusto());
            System.out.println("------------------------------");
        }
    }

    public List<Paciente> listarPacientes() {
        return new ArrayList<>(pacientes);
    }
}
