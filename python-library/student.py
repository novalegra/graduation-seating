class Student:

    def __init__(self, first_name, last_name, has_priority):
        self.first_name = first_name
        self.last_name = last_name
        self.has_priority = has_priority

    def __lt__(self, other):
        return self.last_name < other.last_name

    def __str__(self):
        return self.first_name + " " + self.last_name
