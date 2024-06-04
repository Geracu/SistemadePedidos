import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDePedidos sistema = new SistemaDePedidos();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Crear cuenta");
            System.out.println("2. Autenticarse");
            System.out.println("3. Agregar pedido (sin autenticación)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    sistema.crearCuenta(scanner);
                    break;
                case 2:
                    sistema.autenticarUsuario(scanner);
                    break;
                case 3:
                    sistema.agregarPedidoPublico(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
