package com.atymtay.spring.course_project.aspect;

import com.atymtay.spring.course_project.entities.LiveCourse;
import com.atymtay.spring.course_project.entities.Users;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.validation.constraints.AssertFalse;
import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Component
//@Aspect
//public class UserAspect {
//
//    @Before("com.atymtay.spring.course_project.aspect.MyPoincuts.getAllData()")
//    public void beforeGetUsersData(){
//        System.out.println("beforeGetUsersData: trying to get all data's...");
//        System.out.println("<--------------------------------------------->");
//    }
//
//    @Before("com.atymtay.spring.course_project.aspect.MyPoincuts.addCourseByRole()")
//    public void beforeAddCourseByRole(JoinPoint joinPoint){
//        System.out.println("beforeAddCourseByRole: trying to add some data...");
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//
//        if(methodSignature.getName().equals("addByRole")){
//            Object []objects = joinPoint.getArgs();
//
//            for(Object obj: objects){
//                if(obj instanceof String){
//                    DBManager dbManager = new DBManager();
//                    System.out.println("Checking for authorization...");
//
//                    Users user = dbManager.getUserByName(obj.toString());
//
//                    if(user.getRoles().equals("Admin")){
//                        LiveCourse liveCourse = (LiveCourse) Arrays.stream(objects)
//                                .filter(o -> o instanceof LiveCourse)
//                                .findFirst().get();
//
//                        System.out.println(liveCourse);
//                        dbManager.addLiveCourse(liveCourse);
//
//                        System.out.println("Course data added!");
//                        System.out.println("<--------------------------->");
//                    }
//                }
//            }
//
//        }
//    }
//
//
//    @AfterReturning(
//            pointcut = "com.atymtay.spring.course_project.aspect.MyPoincuts.getUser()",
//            returning = "user"
//    )
//    public void afterReturningUserData( Optional<Users> user){
//
//        System.out.println("afterReturningUserData: logging to get user data...");
//
//        Optional<Users> users = Optional.of(user.get());
//        System.out.println("---------Before changes---------");
//        System.out.println(users.get());
//
//        System.out.println("--------After changes----------");
//        users.get().setName("Gabit");
//        users.get().setRoles("Moderator");
//
//    }
//
//    @AfterThrowing(
//            pointcut = "com.atymtay.spring.course_project.aspect.MyPoincuts.allGetMethods()",
//            throwing = "exception"
//    )
//    public void afterThrowingAllGetMethodAdvice(Throwable exception){
//
//        System.out.println("afterThrowingAllGetMethodAdvice:  logging for handling exception " +
//                exception);
//        System.out.println("-----------------------------------------------------");
//    }
//
//
//    @After("com.atymtay.spring.course_project.aspect.MyPoincuts.allGetMethods()")
//    public void afterGetMethods(){
//        System.out.println("afterGetMethods: finishing the method call or handling the exception.");
//        System.out.println("---------------------------------");
//    }
//
//    @Around("com.atymtay.spring.course_project.aspect.MyPoincuts.allGetMethods()")
//    public Object aroundGetMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        System.out.println("aroundGetMethodAdvice: logging to get data...");
//        Object obj = null;
//
//        try {
//            obj = proceedingJoinPoint.proceed();
//            System.out.println(obj);
//        } catch (Exception e){
//            System.out.println("aroundGetMethodAdvice: handling exception...");
//            throw e;
//        }
//
//        System.out.println("aroundGetMethodAdvice: succesfully finished execution!");
//
//        return obj;
//    }
//
//}
