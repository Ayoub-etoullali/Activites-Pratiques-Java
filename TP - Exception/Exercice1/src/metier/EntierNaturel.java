package metier;

import exceptions.NombreNegatifException;

public class EntierNaturel {

    int val;

    public EntierNaturel(){}
    public EntierNaturel(int val) throws  NombreNegatifException{
        if(val<0) throw new NombreNegatifException("la valeur est  dans le constructeur !!",val);
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) throws  NombreNegatifException {
        if(val<0) throw new NombreNegatifException("la valeur est négative dans setVal() !!",val);
        this.val = val;
    }

    public void decrementer() throws  NombreNegatifException{
        if(val<=0) throw new NombreNegatifException("On peut pas décrementer la valeur dans decrementer() !!",val);
        val--;
    }
}
