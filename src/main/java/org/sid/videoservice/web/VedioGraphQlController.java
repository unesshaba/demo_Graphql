package org.sid.videoservice.web;

import org.sid.videoservice.dtos.CreatorRequest;
import org.sid.videoservice.dtos.VedioRequest;
import org.sid.videoservice.entities.Creator;
import org.sid.videoservice.entities.Vedio;
import org.sid.videoservice.mappers.vedioMapper;
import org.sid.videoservice.repositories.CreatorRepository;
import org.sid.videoservice.repositories.VedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VedioGraphQlController {
    @Autowired
    private VedioRepository vedioRepository;
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private vedioMapper vedioMapp;
    @QueryMapping
    public List<Vedio> vedioList(){
        return vedioRepository.findAll();
    }
    @QueryMapping
    public Creator creatorById(@Argument Long id){
        return creatorRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("creator id not found",id)));
    }
    @MutationMapping
    public Creator saveCreator(@Argument CreatorRequest creator){
        Creator creator1=vedioMapp.fromCreatorRequest(creator);
    return creatorRepository.save(creator1);
    }
    @MutationMapping
    public Vedio  saveVideo(@Argument VedioRequest vedio){
        Vedio vedio1=vedioMapp.fromVedioRequest(vedio);
        Creator creator=creatorRepository.save(vedio1.getCreator());
        vedio1.setCreator(creator);
        return vedioRepository.save(vedio1);
    }



}
