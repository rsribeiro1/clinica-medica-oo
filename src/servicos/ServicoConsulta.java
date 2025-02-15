package servicos;

import app.Consulta;
import app.Exame;
import app.Medico;
import app.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ServicoConsulta {
    private List<Consulta> consultas;

    public ServicoConsulta() {
        this.consultas = new ArrayList<>();
    }

    public void agendarConsulta(List<Paciente> pacientes, List<Medico> medicos) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Solicitando data e hora da consulta
        System.out.print("Digite a data e hora da consulta (dd/MM/yyyy HH:mm): ");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, formatter);

        // Solicitando duração
        System.out.print("Digite a duração da consulta em minutos: ");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        // Listando pacientes existentes
        System.out.println("\n--- Pacientes Disponíveis ---");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(i + " - " + pacientes.get(i).getNome() + " (CPF: " + pacientes.get(i).getCpf() + ")");
        }
        System.out.print("Escolha o paciente pelo índice: ");
        int indicePaciente = scanner.nextInt();
        scanner.nextLine();
        Paciente pacienteSelecionado = pacientes.get(indicePaciente);

        // Listando médicos existentes
        System.out.println("\n--- Médicos Disponíveis ---");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(i + " - " + medicos.get(i).getNome() + " (CRM: " + medicos.get(i).getCrm() + ")");
        }
        System.out.print("Escolha o médico pelo índice: ");
        int indiceMedico = scanner.nextInt();
        scanner.nextLine();
        Medico medicoSelecionado = medicos.get(indiceMedico);

        // Solicitando valor da consulta
        System.out.print("Digite o valor da consulta: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        // Criando e adicionando a consulta
        Consulta consulta = new Consulta(dataHora, duracao, pacienteSelecionado, medicoSelecionado, valor);

        // Prescrevendo exames
        System.out.print("Deseja prescrever exames? (S/N): ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            prescreverExames(consulta);
        }

        consultas.add(consulta);
        pacienteSelecionado.adicionarConsulta(consulta);
        medicoSelecionado.adicionarConsulta(consulta);

        System.out.println("Consulta agendada com sucesso!");
    }


    public void cancelarConsulta() {
        Scanner scanner = new Scanner(System.in);

        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }

        // Listando consultas existentes
        System.out.println("\n--- Consultas Agendadas ---");
        for (int i = 0; i < consultas.size(); i++) {
            System.out.println(i + " - " + consultas.get(i));
        }
        System.out.print("Escolha a consulta pelo índice para cancelar: ");
        int indiceConsulta = scanner.nextInt();
        scanner.nextLine();

        if (indiceConsulta < 0 || indiceConsulta >= consultas.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        Consulta consulta = consultas.get(indiceConsulta);
        consulta.setStatus("CANCELADA");
        System.out.println("Consulta cancelada com sucesso!");
    }

    public void editarConsulta() {
        Scanner scanner = new Scanner(System.in);

        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }

        // Listando consultas existentes
        System.out.println("\n--- Consultas Agendadas ---");
        for (int i = 0; i < consultas.size(); i++) {
            System.out.println(i + " - " + consultas.get(i));
        }
        System.out.print("Escolha a consulta pelo índice para editar: ");
        int indiceConsulta = scanner.nextInt();
        scanner.nextLine();

        if (indiceConsulta < 0 || indiceConsulta >= consultas.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        Consulta consulta = consultas.get(indiceConsulta);

        // Solicitando nova data e hora
        System.out.print("Digite a nova data e hora da consulta (dd/MM/yyyy HH:mm): ");
        String novaDataHoraStr = scanner.nextLine();
        LocalDateTime novaDataHora = LocalDateTime.parse(novaDataHoraStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        consulta.setDataHora(novaDataHora);

        // Solicitando nova duração
        System.out.print("Digite a nova duração da consulta em minutos: ");
        int novaDuracao = scanner.nextInt();
        scanner.nextLine();
        consulta.setDuracaoMinutos(novaDuracao);

        // Solicitando novo valor
        System.out.print("Digite o novo valor da consulta: ");
        double novoValor = scanner.nextDouble();
        scanner.nextLine();
        consulta.setValor(novoValor);

        System.out.println("Consulta editada com sucesso!");
    }

    public List<Consulta> listarConsultas() {
        return new ArrayList<>(consultas);
    }

    public void notificarConsultasProximas() {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime proximas24Horas = agora.plusHours(24);

        List<Consulta> consultasProximas = consultas.stream()
                .filter(consulta -> consulta.getDataHora().isAfter(agora) && consulta.getDataHora().isBefore(proximas24Horas))
                .collect(Collectors.toList());

        if (consultasProximas.isEmpty()) {
            System.out.println("Nenhuma consulta nas próximas 24 horas.");
            return;
        }

        System.out.println("\n--- Consultas nas Próximas 24 Horas ---");
        for (Consulta consulta : consultasProximas) {
            System.out.println(consulta);
        }
    }
    private void prescreverExames(Consulta consulta) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Quantos exames deseja prescrever? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\n--- Prescrevendo Exame " + (i + 1) + " ---");
            System.out.print("Tipo do exame: ");
            String tipo = scanner.nextLine();
            System.out.print("Data de prescrição (dd/MM/yyyy): ");
            LocalDate dataPrescricao = LocalDate.parse(scanner.nextLine(), formatter);
            System.out.print("Custo do exame: ");
            double custo = scanner.nextDouble();
            scanner.nextLine();

            Exame exame = new Exame(tipo, dataPrescricao, custo);
            consulta.prescreverExame(exame);
        }
    }
}