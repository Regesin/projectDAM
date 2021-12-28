package com.produce.repository;

import com.produce.exceptions.ProduceNotFoundException;
import com.produce.model.Fertilizer;
import com.produce.model.Produce;
import com.produce.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface IProduceRepository extends JpaRepository<Produce,Integer>{


    List<Produce> findByKind(String kind) throws ProduceNotFoundException;

    List<Produce> findByProduce(String produce) throws ProduceNotFoundException;


    List<Produce> findByType(Type type) throws ProduceNotFoundException;

    @Query("from Produce p where p.produce=?1 and p.quintal<=?2 and p.bidPrice>=?3")
    List<Produce> findByProQuiBid(String produce,double quintal, double bidPrice) throws ProduceNotFoundException;

    @Query("from Produce p where p.produce=?1 and p.fertilizer<=?2 ")
    List<Produce> findByProFerti(String produce, Fertilizer fertilizer) throws ProduceNotFoundException;

//    @Query("from Produce p where p.startDate=?1")
//    List<Produce> getByDateTime(LocalDateTime date);
//
    @Query("from Produce p where p.startDate=?1")
    List<Produce> findByDate(LocalDate date);




}
