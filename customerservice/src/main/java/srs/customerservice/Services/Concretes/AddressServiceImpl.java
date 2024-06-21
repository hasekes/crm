package srs.customerservice.Services.Concretes;

import org.springframework.stereotype.Service;
import srs.customerservice.Entities.Address;
import srs.customerservice.Entities.Customer;
import srs.customerservice.Repositories.AddressRepository;
import srs.customerservice.Repositories.CustomerRepository;
import srs.customerservice.Services.Abstract.AddressService;
import srs.customerservice.Services.DTOs.Request.Address.AddAddressRequest;
import srs.customerservice.Services.DTOs.Request.Address.UpdateAddressRequest;
import srs.customerservice.Services.DTOs.Response.AddCustomerResponse;
import srs.customerservice.Services.DTOs.Response.getAddressResponse;
import srs.customerservice.Services.Mappers.AddressMapper;
import srs.customerservice.Services.Mappers.CustomerMapper;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }



    @Override
    public void addAddress(AddAddressRequest request) {

        //Address address = AddressMapper.INSTANCE.addressFromAddRequest(request);
       // addressRepository.save(address);


        Address adres = new Address();
        adres.setStreet(request.getStreet());
        adres.setDistrict(request.getDistrict());
        adres.setCity(request.getCity());
        adres.setHouseNumber(request.getHouseNumber());
        adres.setDescription(request.getDescription());
        addressRepository.save(adres);



    }


/*
    @Override
    public getAddressResponse getAddress(int id) {

        Address adres = addressRepository.findById(id);

        //Address adresResponse = new Address();
        String city =adres.getCity();
        String description = adres.getDescription();
        String street =  adres.getStreet();
        String district = adres.getDistrict();
        String houseNumber = adres.getHouseNumber();


        return new getAddressResponse(city,district, street, description, houseNumber);
    }*/

    @Override
    public List<Address> getAddressesByCustomerId(Long customerId) {
        return addressRepository.findByCustomerId(customerId);
    }

    @Override
    public void deleteAddressById(Long addressId) {
        addressRepository.deleteById( addressId);
    }


    @Override
    public void updateAddress(int id, UpdateAddressRequest request) {
        Address adres = addressRepository.findById(id);
        adres.setCity(request.getCity());
        adres.setDistrict(request.getDistrict());
        adres.setStreet(request.getStreet());
        adres.setHouseNumber(request.getHouseNumber());

        addressRepository.save(adres);

    }



}