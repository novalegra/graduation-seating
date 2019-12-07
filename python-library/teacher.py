from student import Student

class Teacher:
    students = []
    has_student_with_priority = False

    def __init__(self, first_name, last_name):
        self.first_name = first_name
        self.last_name = last_name

    def __lt__(self, other):
        return self.last_name < other.last_name or not has_student_with_priority

    def __str__(self):
        output = ""
        if has_student_with_priority:
            output += "!HasPriority"

        for student in students:
            output += student + ", "

        output += "\n"
        return output

    def add_student(self, first, last, has_priority):
        if has_priority:
            self.has_student_with_priority = True

        self.students.append(Student(first, last, has_priority))

    def add_teacher(self):
        self.students.insert(0, Student(self.first_name, self.last_name, False))

    def sort_students(self):
        self.students.sort()

    def get_number_of_students(self):
        return len(students)

    def get_student(position):
        return students[position] if position < len(students) else None

    def is_principal(principal_first, principal_last):
        return (lower(self.first_name) == lower(principal_first) 
                and lower(self.last_name) == lower(principal_last)
                )
