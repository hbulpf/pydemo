class Student(object):
	count = 0
	
	def __init__(self, name):
		self.name = name
		Student.count += 1		