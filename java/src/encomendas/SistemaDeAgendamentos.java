package encomendas;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeAgendamentos implements MeuSistemaDeAgendamento{
    private List<Agendamento> agendamentos = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void agendar(String cliente, String data, String hora) throws HorarioIndisponivelException {
        if (!horarioDisponivel(data, hora)) {
            throw new HorarioIndisponivelException("O horário " + hora + " do dia " + data + " já está ocupado!");
        }
        agendamentos.add(new Agendamento(proximoId, cliente, data, hora));
        proximoId++;
    }

    @Override
    public void cancelar(int id) throws AgendamentoNaoEncontradoException {
        for (Agendamento a : agendamentos) {
            if (a.getId() == id) {
                agendamentos.remove(a);
                return;
            }
        }
        throw new AgendamentoNaoEncontradoException("Não existe agendamento com o número " + id);
    }

    @Override
    public void validarDados(String cliente, String data, String hora) throws DadosInvalidosException {
        if (cliente == null || cliente.trim().isEmpty()) {
            throw new DadosInvalidosException("O nome do cliente não pode ficar vazio.");
        }
        if (data == null || !data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new DadosInvalidosException("Data inválida. Use o formato dd/mm/aaaa.");
        }
        if (hora == null || !hora.matches("\\d{2}:\\d{2}")) {
            throw new DadosInvalidosException("Hora inválida. Use o formato hh:mm.");
        }
    }

    @Override
    public List<String> listarAgendamentos() {
        List<String> lista = new ArrayList<>();
        for (Agendamento a : agendamentos) {
            lista.add(a.toString());
        }
        return lista;
    }

    @Override
    public List<String> buscarPorCliente(String cliente) {
        List<String> lista = new ArrayList<>();
        for (Agendamento a : agendamentos) {
            if (a.getCliente().equalsIgnoreCase(cliente)) {
                lista.add(a.toString());
            }
        }
        return lista;
    }

    @Override
    public boolean horarioDisponivel(String data, String hora) {
        for (Agendamento a : agendamentos) {
            if (a.getData().equals(data) && a.getHora().equals(hora)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int contarAgendamentos() {
        return agendamentos.size();
    }
}
