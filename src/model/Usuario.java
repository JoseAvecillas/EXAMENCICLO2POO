// Usuario.java
package model;

public abstract class Usuario {
    protected String usuario;
    protected String clave;

    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() { return usuario; }
    public boolean autenticar(String clave) {
        return this.clave.equals(clave);
    }
}
