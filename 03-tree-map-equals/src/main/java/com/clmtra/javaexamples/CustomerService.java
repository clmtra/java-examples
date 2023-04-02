package com.clmtra.javaexamples;

import com.clmtra.javaexamples.model.Customer;

import java.util.Map;
import java.util.TreeMap;

import static java.util.Comparator.*;

public class CustomerService {

    private final TreeMap<Customer, String> customerStringMap = new TreeMap<>(comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        return customerStringMap.firstEntry();
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return customerStringMap.higherEntry(customer);
    }

    public void add(Customer customer, String data) {
        customerStringMap.put(customer, data);
    }
}
