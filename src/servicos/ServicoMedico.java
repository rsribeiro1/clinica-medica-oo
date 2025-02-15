package servicos;

import app.Medico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicoMedico {
    private List<Medico> medicos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarMedico() {
        System.out.println("\n--- Cadastro de Médico ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        LocalDate dtNascimento = LocalDate.parse(scanner.nextLine());
        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        Medico medico = new Medico(nome, cpf, dtNascimento, crm, especialidade);
        medicos.add(medico);
        System.out.println("Médico cadastrado com sucesso!");
    }

    public void editarMedico() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        }

        System.out.println("\n--- Médicos Cadastrados ---");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(i + " - " + medicos.get(i).getNome() + " (CRM: " + medicos.get(i).getCrm() + ")");
        }
        System.out.print("Escolha o médico pelo índice para editar: ");
        int indiceMedico = scanner.nextInt();
        scanner.nextLine();

        if (indiceMedico < 0 || indiceMedico >= medicos.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        Medico medico = medicos.get(indiceMedico);

        // Solicitando novos dados
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        medico.setNome(novoNome);

        System.out.print("Nova especialidade: ");
        String novaEspecialidade = scanner.nextLine();
        medico.setEspecialidade(novaEspecialidade);

        System.out.println("Médico editado com sucesso!");
    }

    public void removerMedico() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        }

        // Listando médicos existentes
        System.out.println("\n--- Médicos Cadastrados ---");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(i + " - " + medicos.get(i).getNome() + " (CRM: " + medicos.get(i).getCrm() + ")");
        }
        System.out.print("Escolha o médico pelo índice para remover: ");
        int indiceMedico = scanner.nextInt();
        scanner.nextLine();

        if (indiceMedico < 0 || indiceMedico >= medicos.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        Medico medicoRemovido = medicos.remove(indiceMedico);
        System.out.println("Médico " + medicoRemovido.getNome() + " removido com sucesso!");
    }

    public Medico buscarMedicoPorCrm(String crm) {
        return medicos.stream()
                .filter(medico -> medico.getCrm().equals(crm))
                .findFirst()
                .orElse(null);
    }

    public void mostrarTodosMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        }

        System.out.println("\n--- Todos os Médicos ---");
        for (Medico medico : medicos) {
            System.out.println(medico);
        }
    }

    public List<Medico> listarMedicos() {
        return new ArrayList<>(medicos);
    }
}