package encomendas;

import java.time.LocalDate;
import java.util.Date;

public interface SistemaDeAgendamento {

    public void agendar(long idCliente, LocalDate dataHora) throws ;


}
