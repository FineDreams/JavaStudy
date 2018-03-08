package com.yy.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")//声明为prototype，每次获得都会创建一个新的
public class DefaultScopeService {
}
