package com.produce.service;

import com.produce.exceptions.ProduceNotFoundException;
import com.produce.model.Produce;

import java.util.List;

public interface IProduceService {
     /**
      *
      * @param produce
      * @throws ProduceNotFoundException
      */

     void addProduce(Produce produce) throws ProduceNotFoundException;

     void updateProduce(Produce produce) throws ProduceNotFoundException;

     public void deleteProduce (int produceId)throws ProduceNotFoundException;

     Produce getById(int produceId) throws ProduceNotFoundException;

     List<Produce> getAll();

     List<Produce> getByKind(String kind) throws ProduceNotFoundException;

     List<Produce> getByProduce(String produce) throws ProduceNotFoundException;

     List<Produce> getByType(String type) throws ProduceNotFoundException;

     List<Produce> getByProQuiBid(String produce,double quintal, double bidPrice) throws ProduceNotFoundException;

     List<Produce> getByProFerti(String produce,String fertilizer) throws ProduceNotFoundException;

     List<Produce> getByDate(String date);

}
