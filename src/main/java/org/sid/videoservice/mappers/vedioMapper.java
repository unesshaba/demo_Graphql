package org.sid.videoservice.mappers;

import org.modelmapper.ModelMapper;
import org.sid.videoservice.dtos.CreatorRequest;
import org.sid.videoservice.dtos.VedioRequest;
import org.sid.videoservice.entities.Creator;
import org.sid.videoservice.entities.Vedio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class vedioMapper {
//    public Vedio fromVideoRequest(VedioRequest videoRequest){
//        Vedio video = new Vedio();
//        BeanUtils.copyProperties(videoRequest, video);
//        video.setCreator(this.fromCreatorRequest(videoRequest.getCreator()));
//        return video;
//    }
//
//    public Creator fromCreatorRequest(CreatorRequest creatorRequest){
//        Creator creator = new Creator();
//        BeanUtils.copyProperties(creatorRequest, creator);
//        return creator;
//    }
    private final ModelMapper modelMapper=new ModelMapper();

    public Vedio fromVedioRequest(VedioRequest vedio){
       return this.modelMapper.map(vedio,Vedio.class);

    }
    public Creator fromCreatorRequest(CreatorRequest creator){
        return this.modelMapper.map(creator,Creator.class);

    }
}
