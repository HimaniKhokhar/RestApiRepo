package com.RestApi.services;

import com.RestApi.entities.Course;

import java.util.List;

public interface  CourseService{

    public List<Course> getCourses();

    public Course getCourse(long courseId);

    public Course addCourse(Course course);

    public void putCourse(Course course, int updateCourse);

    public void deleteCourse(int courseId);
}