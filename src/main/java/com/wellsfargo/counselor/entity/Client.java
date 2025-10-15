package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "phone_no", nullable = false)
    private Long phoneNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisors financialAdvisors;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Portfolio portfolio;

    public Client() {}

    public Client(String name, String email, Long phoneNo, FinancialAdvisors financialAdvisors) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.financialAdvisors = financialAdvisors;
    }

    // Getters and setters
    public Integer getClientId() { return clientId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Long getPhoneNo() { return phoneNo; }
    public void setPhoneNo(Long phoneNo) { this.phoneNo = phoneNo; }
    public FinancialAdvisors getFinancialAdvisors() { return financialAdvisors; }
    public void setFinancialAdvisors(FinancialAdvisors financialAdvisors) { this.financialAdvisors = financialAdvisors; }
    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
