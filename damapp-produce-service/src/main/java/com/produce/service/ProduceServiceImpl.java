package com.produce.service;

import com.produce.exceptions.ProduceNotFoundException;
import com.produce.model.Fertilizer;
import com.produce.model.Produce;
import com.produce.model.Type;
import com.produce.repository.IProduceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class ProduceServiceImpl implements IProduceService {
    /**
     * calling the methods which are there in IProduceRepository
     * And using the constructor
     */
    IProduceRepository produceRepository;

    public ProduceServiceImpl(IProduceRepository produceRepository) {
        this.produceRepository = produceRepository;
    }

    /**
     *
     * @param produce
     * Here adding the produce
     * @throws ProduceNotFoundException
     */

    @Override
    public void addProduce(Produce produce) throws ProduceNotFoundException {
        produceRepository.save(produce);
    }

    /**
     *
     * @param produce
     * Here updating the produce
     * @throws ProduceNotFoundException
     */

    @Override
    public void updateProduce(Produce produce) throws ProduceNotFoundException {
        produceRepository.save(produce);
    }

    /**
     *
     * @param produceId
     * Here deleting the produce
     * @throws ProduceNotFoundException
     */

    @Override
    public void deleteProduce(int produceId) throws ProduceNotFoundException {
        produceRepository.deleteById(produceId);
    }

    /**
     *
     * @param produceId in the produce
     * @return Returns a Produce found in the database
     * @throws ProduceNotFoundException if no Produce found in the database it should throw exception
     */

    @Override
    public Produce getById(int produceId) throws ProduceNotFoundException {
        return produceRepository.findById(produceId).orElseThrow(() -> new ProduceNotFoundException("Invalid"));
    }

    /**
     *
     * @return a list of Produce found in the database
     */

    @Override
    public List<Produce> getAll() {
        return produceRepository.findAll();
    }

    /**
     *
     * @param kind in the Produce
     * @return Returns list of produce with kind
     * @throws ProduceNotFoundException if kind is not there throws exception
     */

    @Override
    public List<Produce> getByKind(String kind) throws ProduceNotFoundException {
        List<Produce> produces=produceRepository.findByKind(kind);
        if(produces.isEmpty()){
            throw new ProduceNotFoundException("Invalid");
        }
        return produces;
    }

    /**
     *
     * @param produce in the produce
     * @return Returns list of Produce with  produce and it returns produces
     * @throws ProduceNotFoundException if produce is not there throws an exception
     */

    @Override
    public List<Produce> getByProduce(String produce) throws ProduceNotFoundException {
        List<Produce> produces=produceRepository.findByProduce(produce);
        if(produces.isEmpty()){
            throw new ProduceNotFoundException("Invalid");
        }
        return produces;

    }

    /**
     *
     * @param type
     * @return produces with type
     * @throws ProduceNotFoundException if not throws exception
     */

    @Override
    public List<Produce> getByType(String type) throws ProduceNotFoundException {
        List<Produce> produces=produceRepository.findByType(Type.valueOf(type));
        if (produces.isEmpty()){
            throw new ProduceNotFoundException("Invalid");
        }
        return produces;
    }

    /**
     *
     * @param produce
     * @param quintal
     * @param bidPrice
     * @return produces found in the database
     * @throws ProduceNotFoundException if not throws an exception
     */

    @Override
    public List<Produce> getByProQuiBid(String produce, double quintal, double bidPrice) throws ProduceNotFoundException {
        List<Produce> produces=produceRepository.findByProQuiBid(produce,quintal,bidPrice);
        if(produces.isEmpty()){
            throw new ProduceNotFoundException("Invalid");

        }
        return produces;
    }

    /**
     *
     * @param produce
     * @param fertilizer
     * @return produces found in the database
     * @throws ProduceNotFoundException if not throws an exception as invalid
     */

    @Override
    public List<Produce> getByProFerti(String produce, String fertilizer) throws ProduceNotFoundException {
        List<Produce> produces=produceRepository.findByProFerti(produce, Fertilizer.valueOf(fertilizer));
        if (produces.isEmpty()){
            throw new ProduceNotFoundException("Invalid");
        }
        return produces;
    }


    /**
     *
     * @param date
     * @return produces
     */
    @Override
    public List<Produce> getByDate(String date) {
        List<Produce> produces=produceRepository.findByDate(LocalDate.parse(date));
        if(produces.isEmpty()){
            throw new ProduceNotFoundException("invalid");
        }
        return produces;



    }


}
