package com.produce.controllers;

import com.produce.model.Produce;
import com.produce.service.IProduceService;
import com.produce.service.ProduceServiceImpl;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produce-api")
public class ProduceController {
    IProduceService produceService;

    public ProduceController(IProduceService produceService) {
        this.produceService = produceService;
    }
    @PostMapping("/produces")
    public ResponseEntity<Void> addProduce(@RequestBody Produce produce){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","adding produce");
        produceService.addProduce(produce);
        return   ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PutMapping("/produces")
    public ResponseEntity<Void> updateProduce(@RequestBody Produce produce){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","updating produce");
        produceService.updateProduce(produce);
        return   ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/produces/id/{produceId}")
    public ResponseEntity<Void> deleteProduce(@PathVariable("produceId") int produceId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","deleting produce");
        produceService.deleteProduce(produceId);
        return   ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/produces/id/{produceId}")
    public ResponseEntity<Produce> getById(@PathVariable("produceId") int produceId) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting By produce id");
        Produce nproduce=produceService.getById(produceId);
        return   ResponseEntity.ok().headers(headers).body(nproduce);
    }
    @GetMapping("/produces/all")
    public ResponseEntity<List<Produce>> getAll(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting produce details");
        headers.add("info","Getting produce details");
        List<Produce> produces=produceService.getAll();
        ResponseEntity<List<Produce>> produceResponse=new ResponseEntity(produces,headers,HttpStatus.OK);
        return produceResponse;
    }
    @GetMapping("/produces/kind/{kind}")
    public ResponseEntity<List<Produce>> getByKind(@PathVariable("kind") String kind){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting produce details");
        headers.add("info","Getting produce details");
        List<Produce> produces=produceService.getByKind(kind);
        ResponseEntity<List<Produce>> produceResponse=new ResponseEntity(produces,headers,HttpStatus.OK);
        return produceResponse;
    }
    @GetMapping("/produces/produce/{produce}")
    public ResponseEntity<List<Produce>> getByProduce(@PathVariable("produce") String produce){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting produce details");
        headers.add("info","Getting produce details");
        List<Produce> produces=produceService.getByProduce(produce);
        ResponseEntity<List<Produce>> produceResponse=new ResponseEntity(produces,headers,HttpStatus.OK);
        return produceResponse;
    }



}
