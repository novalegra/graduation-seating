#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Dec  7 08:30:16 2019

@author: annaquinlan
"""
from file_utils import parse_file, create_output
from sorting_utils import sort_students, sort_students_into_rows

def graduation_sorting_runner(input_path, output_path, enable_flags):
    teachers = sort_students(
                    parse_file(input_path)
                )
    seating_chart = sort_students_into_rows(teachers)
    create_output(seating_chart, output_path)