package com.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.document.AddressDocument;
import com.document.EmployeDocument;
import com.record.AddressRecord;
import com.record.EmployeRecord;
import com.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements EmployeService {

    private EmployeRepository repository;

    public EmployeServiceImpl(EmployeRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public EmployeRecord saveOrUpdate(EmployeRecord record) {
        var document = new EmployeDocument();
        BeanUtils.copyProperties(record, document);
        var  addressDocuments = extractAddressRecord(record, document);
        document.setAddress(addressDocuments);
        var newDocument = this.repository.save(document);
        Set<AddressRecord> addressRecords = Collections.emptySet();
        if( null != newDocument.getAddress() && !newDocument.getAddress().isEmpty() ){
            addressRecords = extractedAddressRecord(newDocument);
        }
        var newEmployeRecord = extractEmployeRecord(newDocument, addressRecords);
        return newEmployeRecord;
    }

    private Set<AddressDocument> extractAddressRecord(EmployeRecord record, final EmployeDocument document) {
        Set<AddressDocument> addressDocuments = Collections.emptySet();
        if( null != record.address() ){
            addressDocuments =  record.address().stream().map(rec->{
                var doc = AddressDocument
                                        .builder()
                                        .addressType(rec.addressType())
                                        .street(rec.street())
                                        .city(rec.city())
                                        .country(rec.country())
                                        .build();
                return doc;
            }).collect(Collectors.toSet());
        }
        return addressDocuments;
    }

    @Override
    public List<EmployeRecord> listAll() {
        List<EmployeRecord> records = this.repository.findAll().parallelStream().map(document -> {
            Set<AddressRecord> addressRecords = Collections.emptySet();
            if (null != document.getAddress()) {
                addressRecords = extractedAddressRecord(document);
            }
            var record = extractEmployeRecord(document, addressRecords);
            return record;
        }).collect(Collectors.toList());
        return records;
    }

    @Override
    public EmployeRecord employeById(String id) {
        var document = this.repository.findById(id)
                                        .orElseThrow(
                                            ()-> new IllegalArgumentException("Invalid id"));
        Set<AddressRecord> addressRecords = Collections.emptySet();
        if( !document.getAddress().isEmpty() ){
            addressRecords = extractedAddressRecord(document);
        }

        var newEmployeRecord = new EmployeRecord( document.getId(),
                                                            document.getName(), 
                                                            document.getSurname(), 
                                                            document.getSalary(), 
                                                            document.getEmails(), 
                                                            addressRecords);
        return newEmployeRecord;
    }

    @Override
    public String delete(String id) {
        try{
            this.repository.deleteById(id);
            var sb = new StringBuffer();
            sb.append("Employe document id=");
            sb.append(id);
            sb.append(" Deleted");
            return sb.toString();
        }catch(Exception e){
            throw  new IllegalArgumentException("Invalid id");
        }
    }

    private EmployeRecord extractEmployeRecord(EmployeDocument newDocument, Set<AddressRecord> addressRecords) {
        var newEmployeRecord = new EmployeRecord( newDocument.getId(),
                                                            newDocument.getName(), 
                                                            newDocument.getSurname(), 
                                                            newDocument.getSalary(), 
                                                            newDocument.getEmails(), 
                                                            addressRecords);
        return newEmployeRecord;
    }

    private Set<AddressRecord> extractedAddressRecord(EmployeDocument document) {
        Set<AddressRecord> addressRecords = Collections.emptySet();
        addressRecords = document.getAddress().stream().map(a->{
                var addressRecord = new AddressRecord(a.getAddressType(), 
                                                                a.getStreet(), 
                                                                a.getCity(), 
                                                                a.getCountry());
                return addressRecord;
            }).collect(Collectors.toSet());
        return addressRecords;
    }

    @Override
    public List<EmployeRecord> getEmployesBySalaryRange(Integer from, Integer to) {
        List<EmployeRecord> records = Collections.emptyList();
        List<EmployeDocument> employeDocuments = this.repository.getEmployesBySalaryRange(from, to).orElse(Collections.emptyList());
        if( !employeDocuments.isEmpty() ){
            records = employeDocuments.parallelStream().map(document -> {
                Set<AddressRecord> addressRecords = Collections.emptySet();
                if (null != document.getAddress()) {
                    addressRecords = extractedAddressRecord(document);
                }
                var record = extractEmployeRecord(document, addressRecords);
                return record;
            }).collect(Collectors.toList());
        }
        return records;
    }
}