package com.shah.hr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(name = "team")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamId;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "teamId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamEmployee> teamEmployees = new ArrayList();

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public List<TeamEmployee> getTeamEmployees() {
        return teamEmployees;
    }

    public void setTeamEmployees(List<TeamEmployee> teamEmployees) {
        this.teamEmployees = teamEmployees;
    }
}
