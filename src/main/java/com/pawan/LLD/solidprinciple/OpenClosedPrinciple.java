package com.pawan.LLD.solidprinciple;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
@Slf4j
public class OpenClosedPrinciple {

//  traditional method
    class InvoiceDao {
        private SingleResponsibilityPrinciple.Invoice1 invoice;

        public InvoiceDao (SingleResponsibilityPrinciple.Invoice1 invoice) {
            this.invoice = invoice;
        }

        public void saveDataToDb() {
            System.out.println("Saving invoice data to db.");
        }

        public void saveDataToFile(String fileName) {
            System.out.println("Saving invoice data to file.");
        }
    }

//  Single Responsibility Principle

    public interface IInvoiceDao {

        public void save(SingleResponsibilityPrinciple.Invoice invoice);
    }

    public class DBInvoiceDao implements IInvoiceDao {

        @Override
        public void save(SingleResponsibilityPrinciple.Invoice invoice) {
            System.out.println("Saving invoice data to db.");
        }
    }

    public class FileInvoiceDao implements IInvoiceDao {

        @Override
        public void save(SingleResponsibilityPrinciple.Invoice invoice) {
            System.out.println("Saving invoice data to file.");
        }
    }
}
