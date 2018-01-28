package com.yy.day44注解与自定义注解;

import java.lang.annotation.*;

//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME
//)
//@Documented
//@Inherited
public @interface MyAnnotation {
    int param1() default 0;
    String param2() default "";
}
