package com.boson.assessment.items;

import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemCatalog {
    private List<Item> itemList = new ArrayList<>();
    private static ItemCatalog ourInstance;
    private final List<String> MEMBERSHIP_TYPES = List.of("Book Club Membership", "Video Club Membership");
    private final List<String> PHYSICAL_PRODUCT_TYPES = List.of("Book", "Video");

    static {
        try {
            ourInstance = new ItemCatalog();
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (BadParameterException e) {
            e.printStackTrace();
        }
    }

    public static final String FILENAME = "../taskableassesment/data/items.xml";

    public static ItemCatalog getInstance() {
        return ourInstance;
    }


    private ItemCatalog() throws NullParameterException, BadParameterException {
/*        XMLloaderSellers loader = new XMLloaderSellers();
        itemList = loader.getItemDataFromXML(FILENAME);*/
    }

    public void addItem(String id, Float price, String sellerId) throws NullParameterException, BadParameterException {
        Item item = ItemFactory.itemBuilder(id, price, sellerId);
        ItemCatalog.getInstance().itemList.add(item);
    }


    public Float getPrice(String itemId) {
        Float cost = 0f;
        for (Item i : itemList) {
            if (i.getId().equals(itemId)) {
                cost = i.getPrice();
            }
        }
        return cost;
    }

    public String getSellerId(String itemId) {
        String sellerId = new String();
        for (Item i : itemList) {
            if (i.getId().equals(itemId)) {
                sellerId = i.getSellerId();
            }
        }
        return sellerId;
    }

    public Set<String> getIdSet() {
        Set<String> itemIds = new HashSet<>();
        for (Item i : itemList) {
            itemIds.add(((ItemImpl) i).getId());
        }
        return itemIds;
    }

    public Item getItem(String itemId) {
        Item item = null;
        for (Item i : itemList) {
            if (((ItemImpl) i).getId().equals(itemId)){
                item = i;
            }
        }
        return item;
    }

    public List<String> getPhysicalProductTypes() {
        return this.PHYSICAL_PRODUCT_TYPES;
    }

    public List<String> getMembershipTypes() {
        return this.MEMBERSHIP_TYPES;
    }

}
