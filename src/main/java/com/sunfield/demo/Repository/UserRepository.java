package com.sunfield.demo.Repository;

import com.sunfield.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface  UserRepository  extends CrudRepository<User, Integer> {

}
