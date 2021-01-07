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

    public static final String FILENAME = "../taskableassesment/data/buyers.xml";

    public static UserManager getInstance() {
        return ourInstance;
    }

    private UserManager() throws NullParameterException, BadParameterException {

/*        XMLloaderBuyers loader = new XMLloaderBuyers();
        buyerList = loader.getCustomerDataFromXML(FILENAME);*/
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
        for (User u: userList) {
            if(u.getId().equals(userId)){
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

    public void addItem(String userId, String itemId){
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                user.addItem(itemId);
                break;
            }
        }
    }

    public void removeItem(String userId, String itemId){
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                user.removeItem(itemId);
                break;
            }
        }
    }

    public void addBalance(String userId, Float amount){
        for (User user : userList) {
            if (user.getId().equals(userId)) {
                user.addBalance(amount);
                break;
            }
        }
    }

/*    public void addMembership(Integer id, String membership) {
        for (User c : userList) {
            if (((BuyerImpl) c).getId().equals(id)) {
                c.addMembership(membership);
                break;
            }
        }
    }

    public void addPhysicalItem(Integer customerId, String type, Integer itemId) {
        for (User c : userList) {
            if (((BuyerImpl) c).getId().equals(customerId)) {
                c.addPhysicalItem(type, itemId);
                break;
            }
        }
    }

    public Boolean membershipExists(Integer customerId, String membership) {
        Boolean exists = false;
        for (User c : userList) {
            if (((BuyerImpl) c).getId().equals(customerId)) {
                exists = ((BuyerImpl) c).getMemberships().contains(membership);
            }
        }
        return exists;
    }

    public String getAddress(Integer customerId) {
        String address = "";
        for (User c : userList) {
            if (((BuyerImpl) c).getId().equals(customerId)) {
                address = ((BuyerImpl) c).getAddress();
                break;
            }
        }
        return address;
    }*/

    public void printReport() {
        for (User user : userList) {
            System.out.println(user.getId() + " Balance: " + user.getBalance().toString());
            System.out.println("==================================================");
        }
        System.out.println("Escrow Balance: " + EscrowManager.getInstance().getBalance());
    }
}
