package com.example.demo.student;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		Boolean exists = studentRepository.existsById(id);
		if (!exists) {
			throw new IllegalArgumentException("Student with id" + id + " does not exist");
		}
		studentRepository.deleteById(id);
	}

	@Transactional
	public void updateStudent(Long id, String name, String email) {
		Student studentToUpdate = studentRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Student with id" + id + " does not exist"));

		if (name != null && name.length() > 0 && !studentToUpdate.getName().equals(name)) {
			studentToUpdate.setName(name);
		}

		if (email != null && email.length() > 0 && !studentToUpdate.getEmail().equals(email)) {
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("Email taken");
			}
			studentToUpdate.setEmail(email);
		}
	}

}
