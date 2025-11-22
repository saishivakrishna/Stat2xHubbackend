package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Entity.Brand;

public interface BrandRepo extends JpaRepository<Brand, Long> {
}
