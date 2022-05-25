package services;

import entities.ContractEntity;
import entities.InstallmentEntity;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.MONTH;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(ContractEntity contract, int months) {
        double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            Date date = addMonths(contract.getDate(), i);
            double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
            double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
            contract.addInstallment(new InstallmentEntity(date, fullQuota));
        }
    }

    private Date addMonths(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(MONTH, n);
        return calendar.getTime();
    }
}
