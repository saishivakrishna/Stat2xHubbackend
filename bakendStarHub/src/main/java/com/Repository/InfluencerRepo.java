package com.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Influencer;


public interface InfluencerRepo extends JpaRepository<Influencer, Long> {
}
