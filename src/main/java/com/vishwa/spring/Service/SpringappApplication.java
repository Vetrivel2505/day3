package com.vishwa.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishwa.spring.Repository.EmployeeRepo;
import com.vishwa.spring.model.Employee;

@Service
public class SpringappApplication implements ApiService {
    @Autowired
    private EmployeeRepo taskRepository;
	@Override
	public boolean addTask(Employee task) {
		boolean taskExists=taskRepository.existsByEmail(task.getEmail());
		if(!taskExists) {
			taskRepository.save(task);
			return true;
		}else {
			return false;
	}
  }
	@Override
	public List<Employee> getTask(){
		return taskRepository.findAll();
	}
	@Override
	public boolean updateTask(Long id,Employee task) {
		taskRepository.saveAndFlush(task);
		Optional<Employee> existingTaskOptional = taskRepository.findById(id);
		if(existingTaskOptional.isPresent()) {
		Employee taskExists = existingTaskOptional.get();
		taskExists.setName(task.getName());
		taskExists.setEmail(task.getEmail());
		taskExists.setPassword(task.getPassword());
		taskRepository.save(taskExists);
		return true;
	}else {
		return false;
	}
	}
}