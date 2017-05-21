/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xogo;

import Clases_Peza.Peza;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Carlos
 */
public class Taboleiro {
    HashMap<Integer,HashMap<Integer,Peza>> taboleiro = new HashMap<Integer,HashMap<Integer,Peza>>(8);
    
    public Peza put(Integer x, Integer y, Peza valor) {
        HashMap<Integer, Peza> map;
        if (taboleiro.containsKey(x)) {
            map = taboleiro.get(x);
        } else {
            map = new HashMap<Integer, Peza>();
            taboleiro.put(x, map);
        }

        return map.put(y, valor);
    }
    
    public Peza get(Integer x, Integer y) {
        if (taboleiro.containsKey(x)) {
            return taboleiro.get(x).get(y);
        } else {
            return null;
        }
    }
    public boolean containsKeys(Integer key1, Integer key2) {
        return taboleiro.containsKey(key1) && taboleiro.get(key1).containsKey(key2);
    }

    public void clear() {
        taboleiro.clear();
    }
}
