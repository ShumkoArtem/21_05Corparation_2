package com.corparation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Corparation implements Serializable {

    private List <Imployee> imployeeList;

    public Corparation() {
        List<Imployee> imployeeList = new ArrayList<>();
        this.imployeeList = imployeeList;
    }

    @Override
    public String toString() {
        return "Corparation{" +
                "imployeeList=" + imployeeList +
                '}';
    }

    public List<Imployee> getImployeeList() {
        return imployeeList;
    }

    public void setImployeeList(List<Imployee> imployeeList) {
        this.imployeeList = imployeeList;
    }

    public void addList(Imployee i){
        this.imployeeList.add(i);
    }

    public void print(){
        for (Imployee i : this.getImployeeList()) {
            System.out.println(i);
        }
    }
}
