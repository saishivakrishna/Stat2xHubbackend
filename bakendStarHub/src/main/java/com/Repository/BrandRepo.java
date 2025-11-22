package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
