package principal;

import servicos.ServicoMedico;
import servicos.ServicoPaciente;
import servicos.ServicoConsulta;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicoMedico servicoMedico = new ServicoMedico();
        ServicoPaciente servicoPaciente = new ServicoPaciente();
        ServicoConsulta servicoConsulta = new ServicoConsulta();
        int opcao;

        do {
            System.out.println("\n--- Sistema de Gerenciamento de Clínica Médica ---");
            System.out.println("1. Cadastro de Médicos");
            System.out.println("2. Cadastro de Pacientes");
            System.out.println("3. Agendamento de Consultas");
            System.out.println("4. Listagem de Consultas");
            System.out.println("5. Cancelar Consulta");
            System.out.println("6. Editar Consulta");
            System.out.println("7. Listar Médicos");
            System.out.println("8. Listar Pacientes");
            System.out.println("9. Notificar Consultas Próximas");
            System.out.println("10. Listar Exames de um Paciente");
            System.out.println("11. Editar Médico");
            System.out.println("12. Remover Médico");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    servicoMedico.cadastrarMedico();
                    break;
                case 2:
                    servicoPaciente.cadastrarPaciente();
                    break;
                case 3:
                    servicoConsulta.agendarConsulta(servicoPaciente.listarPacientes(), servicoMedico.listarMedicos());
                    break;
                case 4:
                    System.out.println("\n--- Listagem de Consultas ---");
                    servicoConsulta.listarConsultas().forEach(System.out::println);
                    break;
                case 5:
                    servicoConsulta.cancelarConsulta();
                    break;
                case 6:
                    servicoConsulta.editarConsulta();
                    break;
                case 7:
                    System.out.println("\n--- Listagem de Médicos ---");
                    servicoMedico.listarMedicos().forEach(System.out::println);
                    break;
                case 8:
                    System.out.println("\n--- Listagem de Pacientes ---");
                    servicoPaciente.listarPacientes().forEach(System.out::println);
                    break;
                case 9:
                    servicoConsulta.notificarConsultasProximas();
                    break;
                case 10:
                    System.out.print("Digite o CPF do paciente: ");
                    String cpf = scanner.nextLine();
                    servicoPaciente.listarExamesDoPaciente(cpf);
                    break;
                case 11:
                    servicoMedico.editarMedico();
                    break;
                case 12:
                    servicoMedico.removerMedico();
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}