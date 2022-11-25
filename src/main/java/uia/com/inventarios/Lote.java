package uia.com.inventarios;

public class Lote extends InfoUIA{

    private String fechaIngreso = "";
    private Proveedor proveedor = new Proveedor();
    private Embalaje embalajePrimario = new Embalaje();
    private Embalaje embalajeSecundrio = new Embalaje();
    private Embalaje embalajeTerciario = new Embalaje();

    public Lote() {
        super();
    }

    public Lote(String idLote, String descLote, String cantidad, String fechaIngreso, String idProv, String descProv)
    {
        super("Lote", idLote, descLote, cantidad, "Ingresado");
        this.fechaIngreso = fechaIngreso;
        proveedor.setName(descLote);
        proveedor.setId(idProv);
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Embalaje getEmbalajePrimario() {
        return embalajePrimario;
    }

    public void setEmbalajePrimario(Embalaje embalajePrimario) {
        this.embalajePrimario = embalajePrimario;
    }

    public Embalaje getEmbalajeSecundrio() {
        return embalajeSecundrio;
    }

    public void setEmbalajeSecundrio(Embalaje embalajeSecundrio) {
        this.embalajeSecundrio = embalajeSecundrio;
    }

    public Embalaje getEmbalajeTerciario() {
        return embalajeTerciario;
    }

    public void setEmbalajeTerciario(Embalaje embalajeTerciario) {
        this.embalajeTerciario = embalajeTerciario;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
