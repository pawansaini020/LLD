package com.pawan.LLD.lld.splitwise;

import java.util.Arrays;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
public class Splitwise {

    public static void main(String[] args) {
        GroupManager groupManager = new GroupManager();
        UserManager userManager = new UserManager();
        User pawan = userManager.createUser(1L, "Pawan", "pawan@xyz.com", "1234567890");
        User gopesh = userManager.createUser(2L, "gopesh", "gopesh@xyz.com", "1234567890");
        User shreyansh = userManager.createUser(3L, "shreyansh", "shreyansh@xyz.com", "1234567890");
        User viman = userManager.createUser(4L, "viman", "viman@xyz.com", "1234567890");
        User mayank = userManager.createUser(5L, "mayank", "mayank@xyz.com", "1234567890");

        Group group = groupManager.createGroup("gokarna", "Gokarna Trip", Arrays.asList(pawan, gopesh, shreyansh, viman, mayank));
        groupManager.addExpense("gokarna", 300.0, shreyansh, SplitType.EQUAL, Arrays.asList(), "Petrol");
        groupManager.addExpense("gokarna", 300.0, shreyansh, SplitType.EQUAL, Arrays.asList(), "The Royal Wine");
        groupManager.addExpense("gokarna", 875.0, gopesh, SplitType.EXACT, Arrays.asList(100d, 200d, 300d, 100d, 175d), "Liquor");
        groupManager.addExpense("gokarna", 4098.0, gopesh, SplitType.PERCENT, Arrays.asList(10d, 20d, 30d, 20d, 20d), "Return Ticket");

        groupManager.printExpense("gokarna");
        groupManager.showSettlement("gokarna");
    }
}
