package org.sample.auth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@javax.persistence.Entity
@Table(appliesTo = "account_request")

public class AccountRequest implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1891338590815368376L;
	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Long Id;
    @Column(name="username" ,nullable = false)
	private String username;
    @Column(name="password")
    private String password;
    @Column(name="scope")
    private String scope;
    public AccountRequest() {
    }

    public AccountRequest(String username,String password,String scope) {
        this.username = username;
        this.password = password;
        this.scope= scope;
    }

   /* public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }*/

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setScope(String scope){
    }
    public String getScope()
    {
    	return scope;
    }
    
}