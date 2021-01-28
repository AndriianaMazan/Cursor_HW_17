package com.company.repository;

import com.company.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
    List<Laptop> findAllByOrderByBrandDesc();

    List<Laptop> findAllByRamGreaterThan(int rom);

    List<Laptop> findAllBySecondaryMarketIsTrue();
}
