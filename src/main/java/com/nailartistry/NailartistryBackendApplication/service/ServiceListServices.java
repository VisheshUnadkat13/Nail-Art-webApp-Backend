package com.nailartistry.NailartistryBackendApplication.service;

import com.nailartistry.NailartistryBackendApplication.model.ServiceList;
import com.nailartistry.NailartistryBackendApplication.repo.ServiceListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceListServices {

    @Autowired
    private ServiceListRepo serviceListRepo;

    public List<ServiceList> getAllServices() {
        return serviceListRepo.findAll();
    }

    public Optional<ServiceList> getServicesById(long id) {
        return serviceListRepo.findById(id);
    }

    public ServiceList savedServicelist(ServiceList serviceList) {
        return serviceListRepo.save(serviceList);
    }

    public void deleteServiceListById(long id) {
        serviceListRepo.deleteById(id);
    }
}
