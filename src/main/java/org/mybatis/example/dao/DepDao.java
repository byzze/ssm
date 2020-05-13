package org.mybatis.example.dao;

import org.mybatis.example.entity.Dep;

public interface DepDao {

    public Dep selectDep(Integer dep_id);

    public Dep selectDepAndUser(Integer dep_id);
}
