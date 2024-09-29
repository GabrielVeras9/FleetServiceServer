package br.com.fleetmanagement.enuns;

public enum UsuarioEnuns {
    ADMIN("ADMIN"),
    
    USER("USER");
    
    private final String role;
    
    UsuarioEnuns(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
