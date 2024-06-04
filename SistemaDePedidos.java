import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaDePedidos {
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private List<Pedido> listaPedidos = new ArrayList<>();
    private Usuario usuarioActual = null;

    public void crearCuenta(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("UserName: ");
        String userName = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, userName, password, email);
        listaUsuarios.add(usuario);
        System.out.println("Cuenta creada exitosamente.");
    }

    public void autenticarUsuario(Scanner scanner) {
        System.out.print("UserName: ");
        String userName = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUserName().equals(userName) && usuario.getPassword().equals(password)) {
                usuarioActual = usuario;
                System.out.println("Autenticado exitosamente.");
                mostrarMenuUsuario(scanner);
                return;
            }
        }
        System.out.println("Usuario o contraseña incorrectos.");
    }

    private void mostrarMenuUsuario(Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Agregar pedido");
            System.out.println("2. Editar pedido");
            System.out.println("3. Listar pedidos");
            System.out.println("4. Eliminar pedido");
            System.out.println("5. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    agregarPedido(scanner);
                    break;
                case 2:
                    editarPedido(scanner);
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4:
                    eliminarPedido(scanner);
                    break;
                case 5:
                    usuarioActual = null;
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public void agregarPedidoPublico(Scanner scanner) {
        agregarPedido(scanner);
    }

    public void agregarPedido(Scanner scanner) {
        System.out.print("Nombre de quien envía el pedido: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Tipo de pedido: ");
        String tipo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Fecha de entrega: ");
        String fechaEntrega = scanner.nextLine();
        System.out.print("Fecha de recolección: ");
        String fechaReco = scanner.nextLine();
        System.out.print("Cantidad de artículos: ");
        int cantidad = scanner.nextInt();
        System.out.print("Costo: ");
        double costo = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Pedido pedido = new Pedido(nombreCliente, tipo, descripcion, fechaEntrega, fechaReco, cantidad, costo);
        listaPedidos.add(pedido);
        System.out.println("Pedido agregado exitosamente.");
    }

    public void editarPedido(Scanner scanner) {
        listarPedidos();
        System.out.print("Ingrese el ID del pedido a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Pedido pedido : listaPedidos) {
            if (pedido.getId() == id) {
                System.out.print("Nuevo nombre de quien envía el pedido: ");
                pedido.setNombreCliente(scanner.nextLine());
                System.out.print("Nuevo tipo de pedido: ");
                pedido.setTipo(scanner.nextLine());
                System.out.print("Nueva descripción: ");
                pedido.setDescripcion(scanner.nextLine());
                System.out.print("Nueva fecha de entrega: ");
                pedido.setFechaEntrega(scanner.nextLine());
                System.out.print("Nueva fecha de recolección: ");
                pedido.setFechaReco(scanner.nextLine());
                System.out.print("Nueva cantidad de artículos: ");
                pedido.setCantidad(scanner.nextInt());
                System.out.print("Nuevo costo: ");
                pedido.setCosto(scanner.nextDouble());
                scanner.nextLine(); // Consume newline
                System.out.println("Pedido editado exitosamente.");
                return;
            }
        }
        System.out.println("Pedido no encontrado.");
    }

    public void listarPedidos() {
        if (listaPedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
        } else {
            for (Pedido pedido : listaPedidos) {
                System.out.println(pedido);
            }
        }
    }

    public void eliminarPedido(Scanner scanner) {
        listarPedidos();
        System.out.print("Ingrese el ID del pedido a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Pedido pedidoAEliminar = null;
        for (Pedido pedido : listaPedidos) {
            if (pedido.getId() == id) {
                pedidoAEliminar = pedido;
                break;
            }
        }

        if (pedidoAEliminar != null) {
            listaPedidos.remove(pedidoAEliminar);
            System.out.println("Pedido eliminado exitosamente.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }
}
