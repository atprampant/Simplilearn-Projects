package org.simplilearn.sportyshoes.services;

import org.modelmapper.ModelMapper;
import org.simplilearn.sportyshoes.dto.ShoeDto;
import org.simplilearn.sportyshoes.entities.OrderItems;
import org.simplilearn.sportyshoes.entities.Shoes;
import org.simplilearn.sportyshoes.repositories.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeService {

    @Autowired
    ShoeRepository shoeRepository;

    ModelMapper modelMapper=new ModelMapper();
    public Shoes addAShoe(ShoeDto shoeDto)
    {
        Shoes shoe=modelMapper.map(shoeDto, Shoes.class);
        return shoeRepository.save(shoe);
    }

    public List<Shoes> getAllShoes()
    {
        return shoeRepository.findAll();
    }


}
