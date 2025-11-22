package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Entity.Brand;
import com.Repository.BrandRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/brand")
public class BrandController {

    @Autowired
    private BrandRepo repo;

    @PostMapping("/register")
    public Brand registerBrand(@RequestBody Brand brand) {
        return repo.save(brand);
    }
}
