package com.vithal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vithal.entity.Address;
import com.vithal.entity.Employee;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
    List<Address> findByEmployee(Employee employee);
}
