package com.Handball.Analyzer.service;

import com.Handball.Analyzer.model.Gym;
import com.Handball.Analyzer.repository.GymRepository;
import com.Handball.Analyzer.requestDtos.backoffice.CreateGymDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymService {

    @Autowired
    GymRepository gymRepository;


    public Gym createGym(CreateGymDto createGymDto) {
        try {

            Gym gym = new Gym(createGymDto.getName(), createGymDto.getStreet(), createGymDto.getPlz(), createGymDto.getHousenumber(), createGymDto.getLocation());
            Gym newGym = gymRepository.save(gym);
            return newGym;
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }

    }
}
