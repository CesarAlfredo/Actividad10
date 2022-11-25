package uia.com.inventarios;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorEntrega extends EntregaNivelInventario
{
    List<SolicitudEntregaMaterial> items = new ArrayList<SolicitudEntregaMaterial>();


    public GestorEntrega(IEntregaNivelInventario inventario)
    {
        super(inventario);
    }

    public GestorEntrega(String nombre)
    {
        super();
        //this.gestorApartado = new GestorApartado();
    }


    public void serializa(SolicitudEntregaMaterial newSSM, String nom) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(nom), newSSM);
    }




    public List<SolicitudEntregaMaterial> getItems()
    {
        return this.items;
    }


    public void setItems(List<SolicitudEntregaMaterial> items) {
        this.items = items;
    }


    public SolicitudEntregaMaterial agregaSolicitudSalidaMaterial(String nomArchivo, String solicitante, String categoria) throws IOException {
        String id = nomArchivo+"_"+String.valueOf(this.getItems().size()+1)+".json";
        String existencia = "";
        IEntregaNivelInventario inventario=null;
        SolicitudEntregaMaterial newSSM = new SolicitudEntregaMaterial(super.inventario, id, solicitante, categoria);
        return newSSM;
    }

    @Override
    public void print() {

    }

    @Override
    public SolicitudEntregaMaterial nuevaSolicitudEntrega(String s) {
        return null;
    }


}
