#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Dec  7 08:30:16 2019

@author: annaquinlan
"""
from tkinter import filedialog
from tkinter import ttk
from tkinter import *

from algorithm_runner import graduation_sorting_runner

root = Tk()

root.title("Graduation Sorting Application")

mainframe = ttk.Frame(root, padding="3 3 12 12")
mainframe.grid(column=0, row=0, sticky=(N, W, E, S))
mainframe.columnconfigure(0, weight=1)
mainframe.rowconfigure(0, weight=1)

def in_browse_func():
    input_path = filedialog.askopenfilename()
    display_input_path.config(text=input_path)

def out_browse_func():
    output_path = filedialog.askopenfilename()
    display_output_path.config(text=output_path)

def runner_func():
    graduation_sorting_runner(display_input_path.cget("text"), display_output_path.cget("text"), rows.get(), row_step.get())

input_path = ""
input_path_label = Label(root)
input_path_label.grid(row=0, column=1)
input_path_label.config(text="Input Path:")

display_input_path = Label(root)
display_input_path.grid(row=0, column=3)

in_browse_button = Button(root, text="Browse", command=in_browse_func)
in_browse_button.grid(row=0, column=2)

output_path_label = Label(root)
output_path_label.grid(row=1, column=1)
output_path_label.config(text="Output Path:")

output_path = ""
display_output_path = Label(root)
display_output_path.grid(row=1, column=3)

out_browse_button = Button(root, text="Browse", command=out_browse_func)
out_browse_button.grid(row=1, column=2)

rows = DoubleVar()
row_widths = [i for i in range(2, 151)]
row_width_dropdown = OptionMenu(root, rows, *row_widths)
row_width_dropdown.grid(row=2, column=2)

row_label = Label(root)
row_label.grid(row=2, column=1)
row_label.config(text="Width of Rows:")

row_step = DoubleVar()
row_steps = [i for i in range(-20, 21)]
row_step_dropdown = OptionMenu(root, row_step, *row_steps)
row_step_dropdown.grid(row=3, column=2)

row_step_label = Label(root)
row_step_label.grid(row=3, column=1)
row_step_label.config(text="Increment for Each Row:")

run_program_button = Button(root, text="Run Sorter", command=runner_func)
run_program_button.grid(row=4, column=2)

root.mainloop()
