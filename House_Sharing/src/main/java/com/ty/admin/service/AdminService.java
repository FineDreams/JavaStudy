package com.ty.admin.service;

import com.ty.admin.domain.Admin;

public interface AdminService {
    Admin queryAdminByName(String adminCode);
}
