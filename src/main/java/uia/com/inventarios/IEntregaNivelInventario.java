package uia.com.inventarios;

import java.io.IOException;
import java.util.List;

public interface IEntregaNivelInventario {
    public void cargaInventario(String nombre);

    void cargaSolicitudEntrega(String nombre);

    public List<InfoItem> busca(int id, String descripcion, String categoria, String cantidad, String idPartida, String idSubpartida, String idCategoria);

    List<InfoItem> entregado(int id, String name, String descCat, String cantidad, String idPartida, String idSubpartida, String idCat);

    public void serializa() throws IOException;

    public void print();

    public SolicitudEntregaMaterial nuevaSolicitudEntrega(String s);

    public void agrega(String idPartida, String descPartida, int cantidad, String idSubpartida, String descSubpartida, String idCat,
                       String descCat, String idLote, String lote, String fechaIngreso,
                       String idProveedor, String descProveedor);


    void cargaSolicitudEntregaToInventario(String s);
}