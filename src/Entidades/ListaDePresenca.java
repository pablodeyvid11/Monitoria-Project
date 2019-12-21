package Entidades;

import SuperClasses.Aluno;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class ListaDePresenca implements Serializable{
    private Map<Aluno, Boolean> mapDia;

    public ListaDePresenca() {
        mapDia = new  TreeMap<>();
    }

    public Map<Aluno, Boolean> getMapDia() {
        return mapDia;
    }

    public void setMapDia(Map<Aluno, Boolean> mapDia) {
        this.mapDia = mapDia;
    }
}
