package com.boson.assessment.users;

import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserManager {
    private List<User> userList = new ArrayList<>();
    private static UserManager ourInstance;

    static {
        try {
            ourInstance = new UserManager();
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (BadParameterException e) {
            e.printStackTrace();
        }
    }

    public static UserManager getInstance() {
        return ourInstance;
    }

    private UserManager() throws NullParameterException, BadParameterException {
    }

    public Set<String> getIdSet() {
        Set<String> userIds = new HashSet<>();
        for (User u : userList) {
            userIds.add(u.getId());
        }
        return userIds;
    }

    public User getUser(String userId) {
        User user = null;
        for (User u : userList) {
            if (u.getId().equals(userId)) {
                user = u;
            }
        }
        return user;
    }

    public User addUser(String id, Float balance, String type) {
        User user = UserFactory.userBuilder(id, balance, type);
        userList.add(user);
        return user;
    }

    public void addItem(String userId, String itemId) {
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                user.addItem(itemId);
                break;
            }
        }
    }

    public void removeItem(String userId, String itemId) {
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                user.removeItem(itemId);
                break;
            }
        }
    }

    public void addBalance(String userId, Float amount) {
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                user.addBalance(amount);
                break;
            }
        }
    }

    public void printReport() {
        for (User user : userList) {
            System.out.println(user.getId() + " Balance: " + user.getBalance().toString());
            System.out.println("==================================================");
        }
        System.out.println("Escrow Balance: " + EscrowManager.getInstance().getBalance());
    }
}
