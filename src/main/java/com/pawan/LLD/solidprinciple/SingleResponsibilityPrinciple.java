package com.pawan.LLD.solidprinciple;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
@Slf4j
public class SingleResponsibilityPrinciple {

//  traditional method
    public class Marker {
        private String name;
        private String color;
        private int year;
        private int price;

        public Marker(String name, String color, int year, int price) {
            this.name = name;
            this.color = color;
            this.year = year;
            this.price = price;
        }
    }

    class Invoice {
        private Marker marker;
        private int quality;

        public Invoice (Marker marker, int quality) {
            this.marker = marker;
            this.quality = quality;
        }

        public int calculatePrice() {
            int price = (marker.price) * this.quality;
            return price;
        }

        public void printInvoice() {
            System.out.println("Printing invoice data.");
        }

        public void saveToData() {
            System.out.println("Saving invoice data.");
        }
    }

//  Single Responsibility Principle

    class Invoice1 {
        private Marker marker;
        private int quality;

        public Invoice1 (Marker marker, int quality) {
            this.marker = marker;
            this.quality = quality;
        }

        public int calculatePrice() {
            int price = (marker.price) * this.quality;
            return price;
        }
    }

    class InvoicePrinter {
        private Invoice1 invoice;

        public InvoicePrinter (Invoice1 invoice) {
            this.invoice = invoice;
        }

        public void printInvoice() {
            System.out.println("Printing invoice data.");
        }
    }

    class InvoiceDao {
        private Invoice1 invoice;

        public InvoiceDao (Invoice1 invoice) {
            this.invoice = invoice;
        }

        public void saveData() {
            System.out.println("Saving invoice data.");
        }
    }
}
