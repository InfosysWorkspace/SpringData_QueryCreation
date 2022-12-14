package com.infy.SpringDataQueryCreation.service;

import com.infy.SpringDataQueryCreation.dto.CustomerDTO;
import com.infy.SpringDataQueryCreation.entity.Customer;
import com.infy.SpringDataQueryCreation.exception.InfyBankException;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {

    public CustomerDTO findByEmailId(String emailId) throws InfyBankException;
    public CustomerDTO findByEmailIdAndName(String emailId, String name) throws InfyBankException;
    public List<CustomerDTO> findByEmailIdOrName(String emailId, String name) throws InfyBankException;
    public List<CustomerDTO> findByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate) throws InfyBankException;
    public List<CustomerDTO> findByDateOfBirthLessThan(LocalDate dateOfBirth) throws InfyBankException;
    public List<CustomerDTO> findByDateOfBirthGreaterThan(LocalDate dateOfBirth) throws InfyBankException;
    public List<CustomerDTO> findByDateOfBirthAfter(LocalDate dateOfBirth) throws InfyBankException;
    public List<CustomerDTO> findByDateOfBirthBefore(LocalDate dateOfBirth) throws InfyBankException;

    public List<CustomerDTO> findByEmailIdNull() throws InfyBankException;
    public List<CustomerDTO> findByNameLike(String pattern) throws InfyBankException;
    public List<CustomerDTO> findByNameOrderByDateOfBirth(String name) throws InfyBankException;
    public List<CustomerDTO> findByNameOrderByDateOfBirthDesc(String name) throws InfyBankException;
}
