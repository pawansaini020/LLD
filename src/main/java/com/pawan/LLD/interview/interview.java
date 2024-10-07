package com.pawan.LLD.interview;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Pawan Saini
 * Created on 28/09/24.
 */
@Slf4j
public class interview {

    //    spocto.com

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void countChar(Node head) {

        if(head==null) {
            log.info("Linked list is null.");
        }

        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        log.info("Linked list mid element is: {}", slow.data);
    }

    @RestControllerAdvice
    public class ControllerAdvicer extends ResponseEntityExceptionHandler {

        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<?> runTimeExHandler(RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @SpringBootConfiguration
//    @ComponentScan
//    @EnableAutoConfiguration
    public void countCharacter() {
        String str = "Hello";
        Map<Character, Long> map = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        Map<Character, Long> charCount = str.chars()
                .filter(c -> !Character.isWhitespace(c))
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        Function.identity(),
                        v -> 1L,                     // Initial value of count
                        Long::sum                    // Merge function to add counts
                ));
        log.info("map: {}", map);
    }
}
