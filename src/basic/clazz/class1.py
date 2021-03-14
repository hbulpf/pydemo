class Student1(object):

	def __init__(self, name, score):
		self.name = name
		self.score = score
	
	def print_score(self):
		print('%s: %s' % (self.name, self.score))
	
	def get_grade(self):
		if self.score >= 90:
			return 'A'
		elif self.score >= 60:
			return 'B'
		else:
			return 'C'
	
	def print_grade(self):
		print('%s: %s' % (self.name, self.get_grade()))

lisa = Student1('Lisa', 99)
bart = Student1('Bart', 59)
print(lisa.name, lisa.get_grade())
print(bart.name, bart.get_grade())

class Student2(object):
	
	def __init__(self, name, gender):
		self.name = name
		self.__gender = gender
	
	def get_gender(self):
		return self.__gender
		
	def set_gender(self, gender):
		self.__gender = gender
	
	def print_age(self):
		print('%s: %s' % (self.name, self.age))		
		
class Student3(object):
	count = 0
	
	def __init__(self, name):
		self.name = name
		Student3.count += 1				