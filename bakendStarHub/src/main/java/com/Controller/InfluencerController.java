package com.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Entity.Influencer;
import com.Service.InfluencerService;





@CrossOrigin("*")
@RestController
@RequestMapping("/api/influencer")
public class InfluencerController {

    @Autowired
    private InfluencerService service;

    @PostMapping("/register")
    public Influencer registerInfluencer(@RequestBody Influencer inf) {
        return service.register(inf);
    }
}

