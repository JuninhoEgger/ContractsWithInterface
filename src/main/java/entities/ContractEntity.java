package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractEntity {

    private Integer number;
    private Date date;
    private Double totalValue;

    private List<InstallmentEntity> installments = new ArrayList<>();

    public ContractEntity(Integer number, Date date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<InstallmentEntity> getInstallments() {
        return installments;
    }

    public void addInstallment(InstallmentEntity installment) {
        installments.add(installment);
    }

    public void removeInstallment(InstallmentEntity installment) {
        installments.remove(installment);
    }
}
