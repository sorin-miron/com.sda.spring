package com.sda.patientportal.repository;

import com.sda.patientportal.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
