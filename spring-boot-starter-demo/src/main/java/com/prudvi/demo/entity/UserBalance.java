package com.prudvi.demo.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_balance")
public class UserBalance implements Serializable {
    private static final long serialVersionUID = -1345899042614540514L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_balance_id_seq")
    @SequenceGenerator(name = "user_balance_id_seq", sequenceName = "user_balance_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "balance")
    private String balance;

    @Column(name = "balance_achieve")
    private Integer balanceAchieve;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "userBalance", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    List<UserBalanceHistory> userBalanceHistories;
}
