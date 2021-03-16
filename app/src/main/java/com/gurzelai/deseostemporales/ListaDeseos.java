package com.gurzelai.deseostemporales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaDeseos implements Serializable {

    List<Deseo> lista;

    public ListaDeseos(){
        lista = new ArrayList<>();
    }

    public void add(Deseo d) {
        lista.add(d);
    }

    public List<Deseo> getLista() {
        return lista;
    }
}

