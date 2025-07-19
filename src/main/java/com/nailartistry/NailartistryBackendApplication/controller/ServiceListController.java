package com.nailartistry.NailartistryBackendApplication.controller;

import com.nailartistry.NailartistryBackendApplication.model.ServiceList;
import com.nailartistry.NailartistryBackendApplication.service.ServiceListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*")
public class ServiceListController {

    @Autowired
    private ServiceListServices serviceListServices;

    @GetMapping
    public ResponseEntity<List<ServiceList>> getAllServices()
    {
        List<ServiceList> serviceLists=serviceListServices.getAllServices();
        return new ResponseEntity<>(serviceLists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ServiceList>> getServiceByid(@PathVariable long id)
    {
        Optional<ServiceList> serviceList=serviceListServices.getServicesById(id);
        if(serviceList.isPresent())
        {
            return new ResponseEntity<>(serviceList,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<ServiceList> createService(@RequestBody ServiceList serviceList)
    {
        ServiceList savedServiceList=serviceListServices.savedServicelist(serviceList);
        return new ResponseEntity<>(savedServiceList,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteServiceList(@PathVariable long id)
    {
        try{
            serviceListServices.deleteServiceListById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
