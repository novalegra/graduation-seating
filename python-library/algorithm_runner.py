#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Dec  7 08:30:16 2019

@author: annaquinlan
"""
from file_utils import parse_file, create_output
from sorting_utils import sort_students_into_rows

def graduation_sorting_runner(input_path, output_path, row_width=40, row_step=2, 
							  principal_first_name="simone", principal_last_name="rick-kennell"):
	# assign students to teachers
    teachers = parse_file(input_path)
    # sort the teachers by (1) if they have a student with priority
    # and (2) last name
    teachers.sort()

    # create the seating chart with the sorted teachers
    seating_chart = sort_students_into_rows(teachers, row_width, row_step, principal_first_name, principal_last_name)

    # write data to the output .csv file
    create_output(seating_chart, output_path)