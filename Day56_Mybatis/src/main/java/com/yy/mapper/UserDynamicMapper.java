package com.yy.mapper;

import com.yy.domain.UserExt;
import com.yy.domain.UserQueryV0;

import java.util.List;

public interface UserDynamicMapper {
    List<UserExt> findUsersByQueryV0(UserQueryV0 userQueryV0);
    int findUsersCount(UserQueryV0 userQueryV0);
    List<UserExt> findUserList(UserQueryV0 userQueryV0);
    List<UserExt> findUsersByIdList(List<Integer> idList);

}
