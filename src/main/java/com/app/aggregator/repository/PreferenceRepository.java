package com.app.aggregator.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.aggregator.entity.Preference;
import com.app.aggregator.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {
    
    // Find preferences by user
    Optional<Preference> findByUser(User user);
    List<Preference> findByUserId(Long userId);
}
