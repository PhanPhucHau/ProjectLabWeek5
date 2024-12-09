package com.example.labweek05.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", nullable = false)
    private Long id;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "role", length = 100)
    private String role;

    @Column(name = "company", length = 120)
    private String company;

    @Column(name = "work_desc", length = 400)
    private String workDesc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "can_id")
    private Candidate can;

}