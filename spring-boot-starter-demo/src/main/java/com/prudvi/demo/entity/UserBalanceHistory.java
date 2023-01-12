package com.prudvi.demo.entity;

import java.io.Serializable;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.prudvi.demo.statval.EnumActivity;
import com.prudvi.demo.statval.EnumsType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_balance_history")
public class UserBalanceHistory implements Serializable {

    private static final long serialVersionUID = 5995768187916160245L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_balance_history_id_seq")
    @SequenceGenerator(name = "user_balance_history_id_seq", sequenceName = "user_balance_history_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "balance_before")
    private Integer balanceBefore;

    @Column(name = "balance_after")
    private Integer balanceAfter;

    @Column(name = "activity")
    @Enumerated(EnumType.STRING)
    private EnumActivity activity;

    @Column(name = "ip")
    private String ip;

    @Column(name = "location")
    private String location;

    @Column(name = "user_agent")
    private String userAgent;

    @Column(name = "author")
    private String author;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EnumsType type;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "user_balance_id", referencedColumnName = "id")
    private UserBalance userBalance;
}
