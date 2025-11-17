package com.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Influencer;
import com.Repository.InfluencerRepo;



@Service
public class InfluencerService {

    @Autowired
    private InfluencerRepo repo;

    @Autowired
    private GenerateService generateService;

    public Influencer register(Influencer inf) {

       
        inf.setReferralCode(generateService.generateReferral());

        return repo.save(inf);
    }
}
