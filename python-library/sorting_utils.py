#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Dec  7 08:30:16 2019

@author: annaquinlan
"""
from teacher import Teacher


def find_principal(data, first_name, last_name):
	for i in range(0, len(data)):
		if data[i].is_principal(first_name, last_name):
			return i

	return -1


def create_new_principal(principal, students):
	t = Teacher(principal.first_name, principal.last_name)

	for student in students:
		t.add_instantiated_student(student)

	t.sort_students()
	return t


def deal_with_principal(principal):
	# remove principal from their list of students because they'll sit up front
	principal.remove_student(0)
	output = []
	student_list = []

	while principal.get_number_of_students() > 0:
		# create subgroups with a maximum of 8 students
		if len(student_list) > 7:
			output.append(create_new_principal(principal, student_list))
			student_list = []

		student_list.append(principal.students[0])
		principal.remove_student(0)

	if len(student_list) > 0:
		output.append(create_new_principal(principal, student_list))

	output.sort()
	return output


def number_of_students_in_row(row):
	count = 0
	for teacher in row:
		count += teacher.get_number_of_students()

	return count


def sort_students_into_rows(teachers, starting_width, step, principal_first_name, principal_last_name):
	(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14) = (
	 	[], [], [], [], [], [], [], [], [], [], [], [], [], [], [])

	overall_seating_chart = [r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14]
	max_rows = len(overall_seating_chart)

	principal_index = find_principal(teachers, principal_first_name, principal_last_name)

	# sort the principal's students into rows
	if principal_index > -1:
		smaller_student_groups = deal_with_principal(teachers[principal_index])
		row = 4 if not smaller_student_groups[0].has_student_with_priority else 0

		for group in smaller_student_groups:
			# make sure we don't go out of bounds if there are a lot of students
			# getting principal-handed diplomas
			if row < max_rows:
				overall_seating_chart[row].append(group)
			else:
				overall_seating_chart[max_rows - 1].append(group)
			row += 1

	# sort rest of teachers
	for teacher in teachers:
		if teacher.is_principal(principal_first_name, principal_last_name):
			continue
		row = 0
		while True:
			if (teacher.get_number_of_students() 
					+ number_of_students_in_row(overall_seating_chart[row]) 
					<= max(0, starting_width + row * step)
					):
				overall_seating_chart[row].append(teacher)
				break
			row += 1
			if row >= max_rows:
				overall_seating_chart[max_rows - 1].append(teacher)
				break

	return overall_seating_chart

