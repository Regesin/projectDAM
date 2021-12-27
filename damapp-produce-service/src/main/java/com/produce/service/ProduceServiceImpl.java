package com.produce.service;

import com.produce.exceptions.ProduceNotFoundException;
import com.produce.model.Fertilizer;
import com.produce.model.Produce;
import com.produce.model.Type;
import com.produce.repository.IProduceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProduceServiceImpl implements IProduceService {
    IProduceRepository produceRepository;

    public ProduceServiceImpl(IProduceRepository produceRepository) {
        this.produceRepository = produceRepository;
    }

    @Override
    public void addProduce(Produce produce) throws ProduceNotFoundException {
        produceRepository.save(produce);
    }

    @Override
    public void updateProduce(Produce produce) throws ProduceNotFoundException {
        produceRepository.save(produce);
    }

    @Override
    public void deleteProduce(int produceId) throws ProduceNotFoundException {
        produceRepository.deleteById(produceId);
    }

    @Override
    public Produce getById(int produceId) throws ProduceNotFoundException {
        return produceRepository.findById(produceId).orElseThrow(() -> new ProduceNotFoundException("Invalid"));
    }

    @Override
    public List<Produce> getAll() {
        return produceRepository.findAll();
    }

    @Override
    public List<Produce> getByKind(String kind) throws ProduceNotFoundException {
        List<Produce> produces=produceRepository.findByKind(kind);
        if(produces.isEmpty()){
            throw new ProduceNotFoundException("Invalid");
        }
        return produces;
    }

    @Override
    public List<Produce> getByProduce(String produce) throws ProduceNotFoundException {
        List<Produce> produces=produceRepository.findByProduce(produce);
        if(produces.isEmpty()){
            throw new ProduceNotFoundException("Invalid");
        }
        return produces;

    }

    @Override
    public List<Produce> getByType(String type) throws ProduceNotFoundException {
        List<Produce> produces=produceRepository.findByType(Type.valueOf(type));
        if (produces.isEmpty()){
            throw new ProduceNotFoundException("Invalid");
        }
        return produces;
    }

    @Override
    public List<Produce> getByProQuiBid(String produce, double quintal, double bidPrice) throws ProduceNotFoundException {
        List<Produce> produces=produceRepository.findByProQuiBid(produce,quintal,bidPrice);
        if(produces.isEmpty()){
            throw new ProduceNotFoundException("Invalid");

        }
        return produces;
    }

    @Override
    public List<Produce> getByProFerti(String produce, String fertilizer) throws ProduceNotFoundException {
        List<Produce> produces=produceRepository.findByProFerti(produce, Fertilizer.valueOf(fertilizer));
        if (produces.isEmpty()){
            throw new ProduceNotFoundException("Invalid");
        }
        return produces;
    }

    @Override
    public List<Produce> getByDateAndTime(String date) {
        return null;
    }

//    @Override
//    public List<Produce> getByDateAndTime(String date) {
//        String dateTime=date;
//        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime dateTime1=LocalDateTime.parse(dateTime,formatter);
//        return produceRepository.getByDateTime(dateTime1);
//    }

    @Override
    public List<Produce> getByDate(String date) {
        return null;
    }

//    @Override
//    public List<Produce> getByDate(String date) {
//        String dateTime=date;
//        DateTimeFormatter formatter=DateTimeFormatter.
//    }


}
