class Student(object):
	
	def __init__(self, name, gender):
		self.name = name
		self.__gender = gender
	
	def get_gender(self):
		return self.__gender
		
	def set_gender(self, gender):
		self.__gender = gender
	
	def print_age(self):
		print('%s: %s' % (self.name, self.age))