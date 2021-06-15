package com.msc.backend.entity;

import com.msc.backend.constant.taskConstant;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "commandID")
    private Long commandID;

    @Column(name = "fileID")
    private Long fileID;

    @Column(name = "solver")
    private String solver;

    @Column(name = "encode")
    private String encode;

    @Column(name = "verificate")
    private String verificate;

    @Column(name = "k")
    private int k = 10;

    @Column(name = "result")
    private String result= taskConstant.UNKNOWN;

    @Column(name = "timeConsumer")
    private double timeConsumer = 0;

    public Task(Long fileID, String solver, String encode, String verificate, int k) {
        this.fileID = fileID;
        this.solver = solver;
        this.encode = encode;
        this.verificate = verificate;
        this.k = k;
    }
}
