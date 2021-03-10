class Animal(object):

	def run(self):
		print('Animal is running...')

class Rabbit(Animal):
	
	def run(self):
		print('Rabbit is running fast...')
	
	def eat(self):
		print('Rabbit is eating carrot...')

class Turtle(Animal):
	
	def run(self):
		print('Turtle is running slowly...')
		
	def sleep(self):
		print('Turtle is sleeping...')

