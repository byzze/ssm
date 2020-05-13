package org.mybatis.example.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class Dep implements Serializable {

    private static final long serialVersionUID = 2L;

    int dep_id;
    String dep_name;
    private List<User> list;
    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Dep{" +
                "dep_id=" + dep_id +
                ", dep_name='" + dep_name + '\'' +
                ", list=" + list +
                '}';
    }
}
