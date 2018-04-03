package com.ty.user.dao;

import com.ty.user.domain.Rental;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RentalMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Rental record);

    int insertSelective(Rental record);

    Rental selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Rental record);

    int updateByPrimaryKey(Rental record);

    int queryRentalCount(Map<String, Object> map);

    List<Rental> queryAllRentalByGroup(Map<String, Object> map);

    int selectDataCountByUid(int uid);

    List<Rental> queryRentalByUid(Map<String, Object> map);

    List<Rental> selectRentalByUid(int uid);

    int queryRentalDataCount();

}