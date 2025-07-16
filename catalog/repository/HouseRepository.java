// HouseRepository.java
package com.aventerprises.backend.catalog.repository;

import com.aventerprises.backend.catalog.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {
    List<House> findByCityIgnoreCase(String city);
    List<House> findByRentLessThanEqual(Double maxRent);
    List<House> findByBedroomsGreaterThanEqual(int bedrooms);
    List<House> findByAvailableTrue();
    List<House> findByPincode(String pincode);
}
