package com.scaler.cart.assignments.services.fetch_types_assignments.assignment_3;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_3.Address;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_3.Person;
import com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_3.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * You need to make sure that all these retrievals happen with minimum number of queries (in most optimised way).
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    /**
     * For all the persons present in DB, capture name of unique cities they have lived at.
     * Sabari - Adyar, Iyypanthangal & Pallikaranai - Chennai & Tiruvallur city
     * Pradeep - T. Nagar, Reteri, Mattudhavani - Chennai, Madurai
     *
     * @return 0utput: [Chennai, Tiruvallur, Madurai]
     */
    public Set<String> getAllUniqueCities() {
        List<Person> personList = this.personRepo.findAll();
        Set<String> uniqueCities = new HashSet<>();
        for (Person person : personList) {
            List<Address> personAddressList = person.getAddresses();
            for (Address address : personAddressList) {
                String city = address.getCity();
                uniqueCities.add(city);
            }
        }
        return uniqueCities;
    }

    /**
     * Capture name of cities uniquely at which person with particular id has lived.
     * Sabari - Adyar, Iyypanthangal & Pallikaranai - Chennai & Tiruvallur city
     * Pradeep - T. Nagar, Reteri, Mattudhavani - Chennai, Madurai
     *
     * @return 0utput: [Chennai, Tiruvallur]
     * @return
     */
    public Set<String> getCitiesWherePersonLivedAt(Long personId) {
        Optional<Person> personDetails = this.personRepo.findById(personId);
        if (personDetails.isEmpty()) throw new RuntimeException("Person ID not found");
        Set<String> uniqueCities = new HashSet<>();
        List<Address> personAddressList = personDetails.get().getAddresses();
        for (Address address : personAddressList) {
            String city = address.getCity();
            uniqueCities.add(city);
        }
        return uniqueCities;
    }
}