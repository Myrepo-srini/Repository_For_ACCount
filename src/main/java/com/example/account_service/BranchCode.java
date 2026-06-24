package com.example.account_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="branchcode")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchCode {

    @Id
    private int id ;
    private String branchName;
    private int branchCode;

}
