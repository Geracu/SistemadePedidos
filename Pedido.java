import java.util.concurrent.atomic.AtomicInteger;

public class Pedido {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String nombreCliente;
    private String tipo;
    private String descripcion;
    private String fechaEntrega;
    private String fechaReco;
    private int cantidad;
    private double costo;

    public Pedido(String nombreCliente, String tipo, String descripcion, String fechaEntrega, String fechaReco,
            int cantidad, double costo) {
        this.id = count.incrementAndGet();
        this.nombreCliente = nombreCliente;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.fechaReco = fechaReco;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setFechaReco(String fechaReco) {
        this.fechaReco = fechaReco;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaEntrega='" + fechaEntrega + '\'' +
                ", fechaReco='" + fechaReco + '\'' +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                '}';
    }
}