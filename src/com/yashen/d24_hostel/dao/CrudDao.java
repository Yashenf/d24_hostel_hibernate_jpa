package com.yashen.d24_hostel.dao;

import com.yashen.d24_hostel.entity.SuperEntity;
import org.hibernate.Session;

import java.util.List;

public interface CrudDao<T extends SuperEntity,Id> extends SuperDao{
    boolean save (Session session, T t);
    boolean update (Session session, T t);
    T find (Session session, Id id);
    boolean delete (Session session, T t);
    List<T> findAll (Session session);
}
