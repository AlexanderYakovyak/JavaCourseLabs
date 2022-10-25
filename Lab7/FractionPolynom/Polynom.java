package FractionPolynom;

import fraction.RationalFraction;

import java.util.List;

public class Polynom {
    private List<RationalFraction> lst;

    public Polynom(List<RationalFraction> lst) {
        this.lst = lst;
    }

    public List<RationalFraction> getLst() {
        return lst;
    }

    public void setLst(List<RationalFraction> lst) {
        this.lst = lst;
    }

    public Polynom addPolynom(Polynom polynom){
        if(polynom.getLst().size() > lst.size()){
            for(int i = 0; i < lst.size(); i++){
                lst.set(i, lst.get(i).add(polynom.getLst().get(i)));
            }
            for(int i = lst.size(); i < polynom.getLst().size(); i++){
                lst.add(polynom.getLst().get(i));
            }
        }else{
            for(int i = 0; i < polynom.lst.size(); i++){
                lst.set(i, lst.get(i).add(polynom.getLst().get(i)));
            }
        }
        return this;
    }

    @Override
    public String toString(){
        String output = "";

        if(lst.get(0).m!=0){
            output += (lst.get(0) + " + ");
        }

        for(int i = 1; i < lst.size(); i++){
            if(i!=lst.size()-1) {
                output += (lst.get(i) + "*x^" + i + " + ");
            }
            else {
                output += (lst.get(i) + "*x^" + i);
            }
        }
        return output;
    }



}
