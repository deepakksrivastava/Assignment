package org.sample.auth.service.impl;

import javax.transaction.Transactional;

import org.sample.auth.dao.AccountRequestRepository;
//import org.sample.auth.dao.impl.AccountRequestRepositoryImpl;
import org.sample.auth.model.AccountRequest;
import org.sample.auth.service.AccountRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class AccountRequestServiceImpl implements AccountRequestService {

@Autowired
 private AccountRequestRepository accountRequestRepository;
@Override
 public void create(AccountRequest accountRequest) {
	accountRequestRepository.create(accountRequest);
 }
@Override
public AccountRequest getAccountRequest(String userName) {
	// TODO Auto-generated method stub
	 return accountRequestRepository.getAccountRequest(userName);
	
}
}