package com.pawan.LLD.soldprinciple;

import com.pawan.LLD.lld.tictactoe.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
public class LiskovSubstitutionPrinciple {

//    derived classes must be completely substitutable for their base classes.
//    In other words, if class A is a subtype of class B, then we should be able to replace B with A without interrupting the behavior of the program.

    @Service
    public class AlertService {

        public int score() {
            return 10;
        }
    }

    @Service
    public class PanicAlertService extends AlertService {

        @Override
        public int score() {
            return 10;
        }
    }

    @Service
    public class AlertConsumer {

        private AlertService alertService;

//        public AlertConsumer(AlertService alertService) {
//            this.alertService = alertService;
//        }
        public AlertConsumer(PanicAlertService alertService) {
            this.alertService = alertService;
        }
    }

    AlertConsumer alertConsumer = new AlertConsumer(new PanicAlertService());
}
