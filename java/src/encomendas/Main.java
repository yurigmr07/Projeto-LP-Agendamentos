package encomendas;

public class Main {
    public static void main(String[] args) {
        MeuSistemaDeAgendamento sistema = new SistemaDeAgendamentos();

        try {
            sistema.validarDados("Yuri", "25/11/2026", "14:00");
            sistema.agendar("Yuri", "25/11/2026", "14:00");
            sistema.validarDados("Maria", "25/11/2026", "15:00");
            sistema.agendar("Maria", "25/11/2026", "15:00");
            System.out.println("Agendamentos feitos com sucesso!");
        } catch (DadosInvalidosException | HorarioIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // 2 - Tentando um horário já ocupado
        try {
            sistema.agendar("João", "25/11/2026", "14:00");
        } catch (HorarioIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // 3 - Dados inválidos
        try {
            sistema.validarDados("", "25-11-2026", "14h");
        } catch (DadosInvalidosException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // 4 - Cancelando um agendamento que não existe
        try {
            sistema.cancelar(99);
        } catch (AgendamentoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // 5 - Cancelando um que existe
        try {
            sistema.cancelar(1);
            System.out.println("Agendamento 1 cancelado!");
        } catch (AgendamentoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // 6 - Listando, buscando e contando
        System.out.println("\nTodos os agendamentos:");
        for (String a : sistema.listarAgendamentos()) {
            System.out.println(a);
        }

        System.out.println("\nAgendamentos da Maria: " + sistema.buscarPorCliente("Maria"));
        System.out.println("Horário 15:00 livre? " + sistema.horarioDisponivel("25/11/2026", "15:00"));
        System.out.println("Total: " + sistema.contarAgendamentos());
    }
    }
