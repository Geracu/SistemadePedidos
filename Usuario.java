public class Usuario {
    private String nombre;
    private String userName;
    private String password;
    private String email;

    public Usuario(String nombre, String userName, String password, String email) {
        this.nombre = nombre;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
