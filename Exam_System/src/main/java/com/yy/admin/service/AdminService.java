package com.yy.admin.service;

import com.yy.admin.domain.Admin;

public interface AdminService {
    Admin selectByCode(String adname);
}
