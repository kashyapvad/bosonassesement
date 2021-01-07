package com.boson.assessment.types;

import com.boson.assessment.Constants;
import com.boson.assessment.exceptions.BadParameterException;
import com.boson.assessment.exceptions.NullParameterException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TypeManager {
    private List<Type> typeList = new ArrayList<>();
    private static TypeManager ourInstance;

    static {
        try {
            ourInstance = new TypeManager();
        } catch (NullParameterException e) {
            e.printStackTrace();
        } catch (BadParameterException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static TypeManager getInstance() {
        return ourInstance;
    }

    private TypeManager() throws NullParameterException, BadParameterException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (String typeClass : Constants.TRANSACTION_CLASSES) {
            Class<?> c = Class.forName(typeClass);
            Constructor<?> cons = c.getConstructor();
            Type rule = (Type) cons.newInstance();
            typeList.add(rule);
        }
    }

    public List<Type> getTypeList() {
        return typeList;
    }
}
