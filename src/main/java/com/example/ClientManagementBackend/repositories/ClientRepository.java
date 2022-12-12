package com.example.ClientManagementBackend.repositories;

import com.example.ClientManagementBackend.datamodels.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
