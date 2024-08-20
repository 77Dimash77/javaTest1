package org.example.sweater.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Mtransaction {

    public Mtransaction() {
    }

    public Mtransaction(Double sum, String currencyshortname) {
        this.sum = sum;
        this.currencyshortname = currencyshortname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long accountfrom;
    private Long accountto;
    private String currencyshortname;
    private Double sum;
    private String expensecategory;
    private LocalDate datatime;
    private Double limitsum;
    private LocalDate limitdatetime;
    private String limitcurrencyshortname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountfrom() {
        return accountfrom;
    }

    public void setAccountfrom(Long accountfrom) {
        this.accountfrom = accountfrom;
    }

    public Long getAccountto() {
        return accountto;
    }

    public void setAccountto(Long accountto) {
        this.accountto = accountto;
    }

    public String getCurrencyshortname() {
        return currencyshortname;
    }

    public void setCurrencyshortname(String currencyshortname) {
        this.currencyshortname = currencyshortname;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getExpensecategory() {
        return expensecategory;
    }

    public void setExpensecategory(String expensecategory) {
        this.expensecategory = expensecategory;
    }

    public LocalDate getDatatime() {
        return datatime;
    }

    public void setDatatime(LocalDate datatime) {
        this.datatime = datatime;
    }

    public Double getLimitsum() {
        return limitsum;
    }

    public void setLimitsum(Double limitsum) {
        this.limitsum = limitsum;
    }

    public LocalDate getLimitdatetime() {
        return limitdatetime;
    }

    public void setLimitdatetime(LocalDate limitdatetime) {
        this.limitdatetime = limitdatetime;
    }

    public String getLimitcurrencyshortname() {
        return limitcurrencyshortname;
    }

    public void setLimitcurrencyshortname(String limitcurrencyshortname) {
        this.limitcurrencyshortname = limitcurrencyshortname;
    }
}
