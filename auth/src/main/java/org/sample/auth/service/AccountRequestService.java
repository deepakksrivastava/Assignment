package org.sample.auth.service;

import org.sample.auth.model.AccountRequest;

public interface AccountRequestService {
	public void create(AccountRequest accountRequest);
	public AccountRequest getAccountRequest(String userName);
}
