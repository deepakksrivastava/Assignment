package org.sample.auth.dao;

import org.sample.auth.model.AccountRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

//extends CrudRepository <AccountRequest,Long>

public interface AccountRequestRepository extends Repository <AccountRequest,Long>  {
	
	 public void create(AccountRequest accountRequest);

	 
	 public void update(AccountRequest accountRequest);

	 
	 //public AccountRequest getAccountRequest(Long id);
	 public AccountRequest getAccountRequest(String userName);

	 
	 public void delete(String userName) ;
}
