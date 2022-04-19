package com.RestApi.services;

import com.RestApi.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImplementation implements CourseService{


    List<Course> list;

    public CourseServiceImplementation(){
        list=new ArrayList<>();
        list.add(new Course(1,"java course","this is my new language"));
        list.add(new Course(2,"springboot course","creating RestApi using Springboot"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course c=null;

      for(Course course:list){
          if(course.getId()==courseId){
              c=course;
              break;
          }
      }
      return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public void putCourse(Course course, int updateCourse) {
        list.stream().map(c->{
                if(c.getId()==updateCourse) {
                    c.setTitle(course.getTitle());
                    c.setDescription(course.getDescription());
                }
                return c;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteCourse(int courseId) {
        list=list.stream().filter(c->c.getId()!=courseId).collect(Collectors.toList());
    }





}
