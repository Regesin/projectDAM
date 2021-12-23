package com.produce.repository;

import com.produce.exceptions.ProduceNotFoundException;
import com.produce.model.Produce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProduceRepository extends JpaRepository<Produce,Integer>{

    List<Produce> findByKind(String kind) throws ProduceNotFoundException;
    List<Produce> findByProduce(String produce) throws ProduceNotFoundException;



}
