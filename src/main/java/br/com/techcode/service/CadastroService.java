package br.com.techcode.service;

import com.mysema.query.types.Predicate;

import java.io.Serializable;
import java.util.List;

public interface CadastroService<T> extends Serializable {

    public List<T> findAll(Predicate predicate);

    public List<T> findAll();

    public T findOne(Predicate predicate);

    public T findOne(Serializable id);

    public T save(T entity);

    public T remove(T entity);

    public long count();
}