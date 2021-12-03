package com.mmtvbd.repository;

import com.mmtvbd.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.ElementCollection;
import javax.persistence.OrderBy;
import java.util.List;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Long> {
    List<Brand> findAllById(long id);
    List<Brand> findAllByOrderByEntryDateDesc();
    List<String> findBrandByBrandName(String name);

}
