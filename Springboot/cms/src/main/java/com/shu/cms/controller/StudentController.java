package com.shu.cms.controller;

import com.shu.cms.entity.RecordsEntity;
import com.shu.cms.entity.StudentEntity;
import com.shu.cms.exception.DatabaseException;
import com.shu.cms.service.RecordsService;
import com.shu.cms.service.StudentService;
import com.shu.cms.service.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    TokenService tokenService;

    @Autowired
    StudentService studentService;

    @Autowired
    RecordsService recordsService;

    @PostMapping("/home")
    @ResponseStatus(HttpStatus.OK)
    StudentEntity GetStudentUser(@RequestHeader("Authorization") String token, @RequestBody String id)
            throws DatabaseException {
        if (tokenService.TokenVerify(token) == true) {
            return studentService.getRowById(id);
        } else {
            throw new DatabaseException();
        }
    }

    @PostMapping("/courseinfo")
    @ResponseStatus(HttpStatus.OK)
    RecordsEntity GetRecords(@RequestHeader("Authorization") String token, @RequestBody String id)
            throws DatabaseException {
        if (tokenService.TokenVerify(token) == true) {
            System.out.println("*********recordsService.getRowById(id):" + recordsService.getRowById(id));
            return recordsService.getRowById(id);
        } else {
            throw new DatabaseException();
        }
    }
}
