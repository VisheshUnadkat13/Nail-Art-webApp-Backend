package com.nailartistry.NailartistryBackendApplication.repo;

import com.nailartistry.NailartistryBackendApplication.model.ContactMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessageRepo extends JpaRepository<ContactMessage,Long> {
}
