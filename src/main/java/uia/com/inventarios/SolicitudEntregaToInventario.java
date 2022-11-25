package uia.com.inventarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolicitudEntregaToInventario extends NivelInventario {

    public SolicitudEntregaToInventario(){
        super();
    }

    public List<InfoItem> entregado(int id, String name, String descCat, String cantidad, String idPartida, String idSubpartida, String idCat)
    {
        int cantidadInt = Integer.parseInt(cantidad);

        List<InfoItem> itemsTemp = new ArrayList<InfoItem>();
        for (Map.Entry<String, InfoItem> item : this.getItems().entrySet())
        {
            InfoItem nodo =  item.getValue();
            if(nodo.getEstatus().contentEquals("Apartado") && cantidadInt>0)
            {
                nodo.setEstatus("Entregado");
                itemsTemp.add(nodo);
                --cantidadInt;
            }
            nodo.print();
        }
        return itemsTemp;
    }
}
