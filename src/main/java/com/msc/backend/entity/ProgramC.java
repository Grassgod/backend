package com.msc.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "programC")
public class ProgramC {

    @Id
    @GeneratedValue
    private Long fileID;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "fileAddress")
    private String fileAddress;

    @Column(name = "total",nullable = false)
    private int total = 0;

    @Column(name = "success",nullable = false)
    private int success = 0;

    @Column(name = "failure",nullable = false)
    private int failure = 0;

    @Column(name = "timeout",nullable = false)
    private int timeout= 0;

    @Column(name = "unknown",nullable = false)
    private int unknown= 0;

    public ProgramC(String fileName, String fileAddress){
        super();
        this.fileName = fileName;
        this.fileAddress = fileAddress;
    }

}