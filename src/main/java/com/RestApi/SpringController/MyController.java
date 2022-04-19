package com.RestApi.SpringController;

import com.RestApi.entities.Course;
import com.RestApi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseServices;

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseServices.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseServices.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseServices.addCourse(course);
    }

    @PutMapping("/courses/{courseId}")
    public Course putCourse(@RequestBody Course course, @PathVariable("courseId") int courseId){

        this.courseServices.putCourse(course,courseId);
        return course;
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable("courseId") int courseId){
        this.courseServices.deleteCourse(courseId);

    }
//    @GetMapping("/home")
//    public String home() {
//        return "this is home page ";
//    }

}
