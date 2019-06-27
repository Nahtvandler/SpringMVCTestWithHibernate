package spring.ListTestPojo;

import java.util.List;

public class ListModel {

    public List<ListElem> listElems;

    public ListModel(List<ListElem> listElems) {
        this.listElems = listElems;
    }

    public List<ListElem> getListElems() {
        return listElems;
    }

    public void setListElems(List<ListElem> listElems) {
        this.listElems = listElems;
    }
}
