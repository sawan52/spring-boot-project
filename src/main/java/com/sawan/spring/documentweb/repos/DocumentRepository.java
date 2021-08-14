package com.sawan.spring.documentweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawan.spring.documentweb.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
