package com.scaler.cart.assignments.services.fetch_types_assignments.assignment_3;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_3.Address;
import com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_3.AddressRepo;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    public Pair<String, String> getCityAndPincodeFromAddressId(Long addressId) {
        Optional<Address> address = this.addressRepo.findById(addressId);
        if (address.isEmpty()) throw new RuntimeException("city or pincode is null");
        Address address1 = address.get();
        return Pair.of(address1.getCity(), address1.getPincode());
    }
}
