#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Dec  7 08:30:16 2019

@author: annaquinlan
"""
from teacher import Teacher

def parse_file(input_path):
    teachers_instantiated = [] # string of first + last names of teachers
    teachers = []

    with open(input_path) as f:
        lines = [line.split() for line in f]   
        for line in lines[1:]:
            line = str(line).split(",")
            teacher_name = line[2].lower() + " " + line[3].lower()

            # convert str -> bool
            if line[4].lower() in ['true', '1', 't', 'y', 'yes', 'yeah', 'yup', 'certainly', 'uh-huh', "true']"]:
                priority = True
            else:
                priority = False

            if teacher_name in teachers_instantiated:
                position = teachers_instantiated.index(teacher_name)
                teachers[position].addStudent(line[0], line[1], priority)
            else:
                t = Teacher(line[2], line[3])
                t.add_student(line[0], line[1], priority)
                teachers.append(t)
                teachers_instantiated.append(teacher_name)

    for t in teachers:
        t.sort_students()

    for t in teachers:
        t.add_teacher()

    return teachers
