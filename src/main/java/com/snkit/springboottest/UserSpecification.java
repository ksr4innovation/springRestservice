package com.snkit.springboottest;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class UserSpecification implements Specification<UserEntity> {
	
	User user;
	
	UserSpecification(User user){
		this.user = user;
	}
		
	@Override
	public Predicate toPredicate(Root<UserEntity> root, 
									CriteriaQuery<?> query, 
									CriteriaBuilder cb) {
		Predicate predicate = cb.conjunction();
		Join<UserEntity,AddressEntity> userAddJoin = root.join("addressList", JoinType.INNER);
		
		
		if (user.getName() != null) {
			predicate.getExpressions().add(cb.equal(root.get("name"),user.getName() ));
		}
		
		if (user.getAddList() != null && user.getAddList().size() > 0 ) {
		
			predicate.getExpressions().add(cb.equal(userAddJoin.get("state"),
											user.getAddList().get(0).getState()));
			
		}
		query.distinct(true);
		
		return predicate;
		
		
	}

}
