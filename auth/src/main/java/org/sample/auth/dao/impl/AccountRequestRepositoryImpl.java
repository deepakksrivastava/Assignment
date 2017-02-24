package org.sample.auth.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContext;

import org.sample.auth.dao.AccountRequestRepository;
import org.sample.auth.model.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public class AccountRequestRepositoryImpl implements AccountRequestRepository  {
	@PersistenceContext
	 private EntityManager entityManager;

	 @Transactional
	 public void create(AccountRequest accountRequest) {
	 entityManager.persist(accountRequest);
	 }

	 @Transactional
	 public void update(AccountRequest accountRequest) {
	 entityManager.merge(accountRequest);
	 }

	/* @Transactional
	 public AccountRequest getAccountRequest(Long id) {
	 return entityManager.find(AccountRequest.class, id);
	 }*/
	 
	 @Transactional
	 public AccountRequest getAccountRequest(String userName) {
	 return entityManager.find(AccountRequest.class, userName);
	 }

	 @Transactional
	 public void delete(String userName) {
		 AccountRequest accountRequest = getAccountRequest(userName);
	 if (accountRequest != null) {
	 entityManager.remove(accountRequest);
	 }
	 }

	@Override
	public AccountRequest getScope(String userName) {
		// TODO Auto-generated method stub
		 return entityManager.find(AccountRequest.class, userName);
	}

	


}
