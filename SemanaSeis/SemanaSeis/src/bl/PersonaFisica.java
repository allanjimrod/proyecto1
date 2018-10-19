package bl;

public class PersonaFisica extends Persona {

    protected String apellido;
    protected String estadoCivil;

    public PersonaFisica() {
        super();
    }

    public PersonaFisica(String nombre, String identificacion, String apellido, String estadoCivil) {
        super(nombre, identificacion);
        this.apellido = apellido;
        this.estadoCivil = estadoCivil;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "PersonaFisica{" +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                "apellido='" + apellido + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }

    public String outData() {
        return this.nombre + "," + this.apellido + "," + this.identificacion + "," + this.estadoCivil;
    }
}
