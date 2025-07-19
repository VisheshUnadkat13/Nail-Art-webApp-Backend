package com.nailartistry.NailartistryBackendApplication.repo;

import com.nailartistry.NailartistryBackendApplication.model.ServiceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceListRepo extends JpaRepository<ServiceList,Long> {
}
