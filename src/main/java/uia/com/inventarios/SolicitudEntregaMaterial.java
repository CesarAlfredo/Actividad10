package uia.com.inventarios;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;



public class SolicitudEntregaMaterial extends RegistroItem implements IEntregaNivelInventario
{
    private String id="";
    private  NivelInventario inventario = null;

    public SolicitudEntregaMaterial()
    {
    }

    public SolicitudEntregaMaterial(NivelInventario inventario, String id, String solicitante, String categoria)
    {
        this.inventario = inventario;
        this.id = id;
    }

    @Override
    public void cargaInventario(String nombre) {

    }

    @Override
    public void cargaSolicitudEntrega(String nombre) {

    }

    @Override
    public List<InfoItem> busca(int id, String descripcion, String categoria, String cantidad, String idPartida, String idSubpartida, String idCategoria) {
        return null;
    }

    @Override
    public List<InfoItem> entregado(int id, String name, String descCat, String cantidad, String idPartida, String idSubpartida, String idCat) {
        return null;
    }

    @Override
    public void serializa() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(id), this);
    }



    @Override
    public void print() {
        super.print();
    }

    @Override
    public SolicitudEntregaMaterial nuevaSolicitudEntrega(String s) {
        return null;
    }

    @Override
    public void agrega(String idPartida, String descPartida, int cantidad, String idSubpartida, String descSubpartida, String idCat, String descCat,
                       String idLote, String descLote, String fechaIngreso, String idProveedor, String descProveedor)
    {
        InfoItem item;
        Lote lote = new Lote(idLote, descLote, String.valueOf(cantidad), fechaIngreso, idProveedor, descProveedor);
        item = this.inventario.agrega(idPartida,descPartida, idSubpartida, descSubpartida, idCat, descCat, String.valueOf(cantidad), lote);

    }

    @Override
    public void cargaSolicitudEntregaToInventario(String s) {

    }


    public void serializa(SolicitudEntregaMaterial sem) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(id), sem);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NivelInventario getInventario() {
        return inventario;
    }

    public void setInventario(NivelInventario inventario) {
        this.inventario = inventario;
    }
}