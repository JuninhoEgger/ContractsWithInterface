package main;

import entities.ContractEntity;
import entities.InstallmentEntity;
import services.ContractService;
import services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        showMessageDialog(null, "ENTER CONTRACT DATA");
        int number = parseInt(showInputDialog("NUMBER:"));
        Date date = sdf.parse(showInputDialog("DATE (dd/MM/yyyy):"));
        double totalValue = parseDouble(showInputDialog("CONTRACT VALUE:"));

        ContractEntity contract = new ContractEntity(number, date, totalValue);
        int n = parseInt(showInputDialog("ENTER NUMBER OF INSTALLMENTS"));

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, n);

        StringBuilder response = new StringBuilder("INSTALLMENTS\n");
        for (InstallmentEntity x : contract.getInstallments()) {
            response.append(x).append("\n");
        }
        showMessageDialog(null, response);
    }
}
