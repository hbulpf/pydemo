class Student(object):
    def __init__(self, name, score):
        self.name = name
        self.score = score
    def get_grade(self):
        if self.score < 0 or self.score > 100:
            raise ValueError('n < 0 or n > 100')
        if self.score <= 100 and self.score >= 80:
            return 'A'
        if self.score >= 60:
            return 'B'
        return 'C'
