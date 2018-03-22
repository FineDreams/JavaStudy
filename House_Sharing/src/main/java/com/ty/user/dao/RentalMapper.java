package com.ty.user.dao;

import com.ty.user.domain.Rental;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Rental record);

    int insertSelective(Rental record);

    Rental selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Rental record);

    int updateByPrimaryKey(Rental record);
}