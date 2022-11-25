package uia.com.inventarios;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SolicitudEntregaMaterial.class, name = "SEM")
})

public class EntregaNivelInventario implements IEntregaNivelInventario
{
    protected NivelInventario inventario;
    protected SolicitudEntregaMaterial sem;

    protected SolicitudEntregaToInventario sei;

    public EntregaNivelInventario(IEntregaNivelInventario inventario)
    {
        super();
        this.inventario = (NivelInventario) new NivelInventario();
    }

    public EntregaNivelInventario()
    {
    }

    @Override
    public void cargaSolicitudEntrega(String nombre)
    {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            sem =  mapper.readValue(new FileInputStream(nombre), SolicitudEntregaMaterial.class );
        }catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.sem.getInventario().print();
    }

    @Override
    public List<InfoItem> busca(int id, String descripcion, String categoria, String cantidad, String idPartida, String idSubpartida, String idCategoria)
    {
        return inventario.busca(id, descripcion, categoria, cantidad, idPartida, idSubpartida, idCategoria);
    }

    @Override
    public List<InfoItem> entregado(int id, String name, String descCat, String cantidad, String idPartida, String idSubpartida, String idCat)
    {
        return inventario.busca(id,name,descCat,cantidad,idPartida,idSubpartida,idCat);
    }


    @Override
    public void serializa() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("ReporteNivelInventario-10.json"), this);
    }

    @Override
    public void print() {

    }

    @Override
    public SolicitudEntregaMaterial nuevaSolicitudEntrega(String s)
    {
        return null;
    }


    public void agrega(String idPartida, String descPartida, int cantidad, String idSubpartida, String descSubpartida, String idCat,
           String descCat, String idLote, String lote, String fechaIngreso,
           String idProveedor, String proveedor)
    {
        InfoItem item = new InfoItem("Item", idPartida, descPartida, descCat, String.valueOf(cantidad), idPartida, idSubpartida, idCat,
                idLote, lote, fechaIngreso, idProveedor, proveedor);
    }

    @Override
    public void cargaSolicitudEntregaToInventario(String nombre) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            sei =  mapper.readValue(new FileInputStream(nombre), SolicitudEntregaToInventario.class );
        }catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.inventario.print();


    }

    public void cargaInventario(String nombre)
    {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            inventario =  mapper.readValue(new FileInputStream(nombre), NivelInventario.class );
        }catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.inventario.print();

    }
}
