package com.produce.service;

import com.produce.exceptions.ProduceNotFoundException;
import com.produce.model.Produce;
import com.produce.repository.IProduceRepository;
import jdk.jshell.Snippet;
import org.springframework.stereotype.Service;

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


}
