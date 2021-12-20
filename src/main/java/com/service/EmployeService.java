package com.service;

import java.util.List;

import com.record.EmployeRecord;

public interface EmployeService {
    public EmployeRecord saveOrUpdate(EmployeRecord address);
    public List<EmployeRecord> listAll();
    public EmployeRecord employeById(String id);
    public String delete(String id);
    public List<EmployeRecord> getEmployesBySalaryRange(Integer from, Integer to);
}
