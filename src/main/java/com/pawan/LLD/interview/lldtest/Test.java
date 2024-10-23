package com.pawan.LLD.interview.lldtest;

/**
 * @author Pawan Saini
 * Created on 07/10/24.
 */
public class Test {

//    spocto.com

//    Communication Engine logic

    class MessageDTO {
        // time
        // comm_id
        // CommType
    }
    interface ICommunicationService {
        void sendMessage(MessageDTO message);
    }

    class WhatsappCommunicationService implements ICommunicationService {
        @Override
        public void sendMessage(MessageDTO message) {
            // logic to send whatsapp
        }
    }

    public enum CommType {
        SMS, EMAIL, WHATSAPP;
    }

    public class CommFactory {

        public ICommunicationService getService(CommType type) {
            // base on type return service
            return new WhatsappCommunicationService();
        }
    }

    public class CommEventConsumer{
        // consumer event
        // if in future schedule or send comm
    }

    // use db scheduler

    class CommController {
        // post rest api to receive request on server service
    }

    class CommService {
        // validate
        // generate comm id && publish event on kafka
    }

    class WhatsappMessageDTO {
        // from
        // to
        // template
        // args
        // additional details based on communication type
    }

     interface ICommValidation {

     }

    class WhatsappCommValidation implements ICommValidation {

        // validate
        //
    }

    class SMSCommValidation implements ICommValidation {

        // validate
    }

//    Db schema
//    Comm status details {
//    id
//    comm id
//    Comm type
//    trigger time
//    Status(VALIDATION_FAILED, SCHEDULED, SUCCESS, FAILED)
//    reason
//    metadata
//    create_time
//    update_time


//    Whatsapp comm details {
//    comm id
//    from
//    to
//    create_time
//    message
//    create_time
//    update_time
//

//    SMS comm details {
//    comm id
//    from
//    to
//    trigger time
//    template
//    args[]
//    create_time
//    update_time

















}
