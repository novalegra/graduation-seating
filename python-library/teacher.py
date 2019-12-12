#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Dec  7 08:30:16 2019

@author: annaquinlan
"""
from student import Student

class Teacher:

    def __init__(self, first_name, last_name):
        self.first_name = first_name
        self.last_name = last_name
        self.students = []
        self.has_student_with_priority = False

    def __lt__(self, other):
        if self.has_student_with_priority == other.has_student_with_priority:
            return self.last_name < other.last_name
        return self.has_student_with_priority

    def __str__(self):
        output = ""
        if self.has_student_with_priority:
            output += "!HasPriority "

        for student in self.students[:-1]:
            output += str(student) + ", "

        output += str(self.students[-1])
        return output

    def add_student(self, first, last, has_priority):
        if has_priority:
            self.has_student_with_priority = True

        self.students.append(Student(first, last, has_priority))

    def add_instantiated_student(self, student):
        if student.has_priority:
            self.has_student_with_priority = True

        self.students.append(student)

    def remove_student(self, index):
        if 0 <= index < len(self.students):
            del self.students[index]

    def add_teacher(self):
        self.students.insert(0, Student(self.first_name, self.last_name, False))

    def sort_students(self):
        self.students.sort()

    def get_number_of_students(self):
        return len(self.students)

    def is_principal(self, principal_first, principal_last):
        return (self.first_name.lower() == principal_first.lower() 
                and self.last_name.lower() == principal_last.lower()
                )
