package com.example.account_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchCodeRepo extends JpaRepository<BranchCode ,Integer> {
    Optional<BranchCode> findByBranchName(String branchName);
}
