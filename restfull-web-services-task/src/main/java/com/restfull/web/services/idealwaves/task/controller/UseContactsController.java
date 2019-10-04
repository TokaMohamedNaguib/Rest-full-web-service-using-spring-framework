package com.restfull.web.services.idealwaves.task.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfull.web.services.idealwaves.task.entity.UserContact;
import com.restfull.web.services.idealwaves.task.exception.ResourceNotFoundException;
import com.restfull.web.services.idealwaves.task.repository.UserContactRepository;
import com.restfull.web.services.idealwaves.task.repository.UserRepository;

@RestController
public class UseContactsController {

	@Autowired
	private UserContactRepository userContactRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users/{userId}/userContacts")
	public List<UserContact> getCoursesByInstructor(@PathVariable(value = "userId") Long userId) {
		return userContactRepository.findByUserId(userId);
	}

	@GetMapping(path = "/users/{userId}/userContacts/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserContact> getUserContactById(@PathVariable(value = "id") Long userContactId)
			throws ResourceNotFoundException {
		UserContact userContact = userContactRepository.findById(userContactId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + userContactId));
		return ResponseEntity.ok().body(userContact);
	}

	@PostMapping(path = "/users/{userId}/userContacts", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserContact createUserContact(@PathVariable(value = "userId") Long userId,
			@Valid @RequestBody UserContact userContact) throws ResourceNotFoundException {
		return userRepository.findById(userId).map(user -> {
			userContact.setUser(user);
			return userContactRepository.save(userContact);
		}).orElseThrow(() -> new ResourceNotFoundException("user not found"));
	}

	@PutMapping("/users/{userId}/userContacts/{contactId}")
	public UserContact updateUserContact(@PathVariable(value = "userId") Long userId,
			@PathVariable(value = "contactId") Long contactId, @Valid @RequestBody UserContact contactRequest)
			throws ResourceNotFoundException {
		if (!userRepository.existsById(userId)) {
			throw new ResourceNotFoundException("userId not found");
		}

		return userContactRepository.findById(contactId).map(contact -> {
			contact.setAddress(contactRequest.getAddress());
			contact.setMobile(contactRequest.getMobile());
			contact.setTelephone(contactRequest.getTelephone());
			return userContactRepository.save(contact);
		}).orElseThrow(() -> new ResourceNotFoundException("course id not found"));
	}

	@DeleteMapping("/users/{userId}/userContacts/{contactId}")
	public ResponseEntity<?> deleteUserContact(@PathVariable(value = "userId") Long userId,
			@PathVariable(value = "contactId") Long contactId) throws ResourceNotFoundException {
		return userContactRepository.findByIdAndUserId(contactId, userId).map(contact -> {
			userContactRepository.delete(contact);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Course not found with id " + contactId + " and instructorId " + userId));
	}

}
