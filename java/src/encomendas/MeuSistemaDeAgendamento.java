package encomendas;

import java.util.List;

public interface MeuSistemaDeAgendamento {

    void agendar(String cliente, String data, String hora) throws HorarioIndisponivelException;

    public void cancelar(int id) throws AgendamentoNaoEncontradoException;


    public void validarDados(String cliente, String data, String hora) throws DadosInvalidosException;


    public List<String> listarAgendamentos();


    public List<String> buscarPorCliente(String cliente);


    public boolean horarioDisponivel(String data, String hora);


    public int contarAgendamentos();
}
