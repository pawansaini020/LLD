package com.pawan.LLD.FitFlipKart;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
@Slf4j
public class WaitlistNotifier {

    private Map<Integer, List<User>> waitlists = new HashMap<>();

    public void addToWaitlist(int slotId, User user) {
        waitlists.putIfAbsent(slotId, new ArrayList<>());
        waitlists.get(slotId).add(user);
        log.info(user.getName() + " added to waitlist for slot " + slotId);
    }

    public void notifyUsers(int slotId) {
        if (waitlists.containsKey(slotId) && !waitlists.get(slotId).isEmpty()) {
            User nextUser = waitlists.get(slotId).remove(0);
            log.info("Notifying " + nextUser.getName() + " that a slot is available!");
        }
    }
}
