package bl;

public class PersonaJuridica extends Persona {

    protected String responsable;
    protected String industria;

    public PersonaJuridica() {
        super();
    }

    public PersonaJuridica(String nombre, String identificacion, String responsable, String industria) {
        super(nombre, identificacion);
        this.responsable = responsable;
        this.industria = industria;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getIndustria() {
        return industria;
    }

    public void setIndustria(String industria) {
        this.industria = industria;
    }

    @Override
    public String toString() {
        return "PersonaJuridica{" +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                "responsable='" + responsable + '\'' +
                ", industria='" + industria + '\'' +
                '}';
    }
    public String outData() {
        return this.nombre + "," + this.identificacion + "," + this.responsable + "," + this.industria;
    }
}
