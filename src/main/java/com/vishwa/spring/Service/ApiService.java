package com.vishwa.spring.Service;

import java.util.List;

import com.vishwa.spring.model.Employee;

public interface ApiService {
      public boolean addTask(Employee task);

	public boolean updateTask(Long id, Employee task);

	List<Employee> getTask();
}
