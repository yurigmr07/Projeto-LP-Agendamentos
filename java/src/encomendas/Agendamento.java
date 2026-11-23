package encomendas;

public class Agendamento {
    private int id;
    private String cliente;
    private String data;
    private String hora;

    public Agendamento(int id, String cliente, String data, String hora) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.hora = hora;
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public String getData() { return data; }
    public String getHora() { return hora; }

    @Override
    public String toString() {
        return "#" + id + " - " + cliente + " - " + data + " às " + hora;
    }
}
