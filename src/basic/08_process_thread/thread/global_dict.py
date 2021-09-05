import threading
global_dict = {}

class Student():
    def __init__(self,name):
        self.name=name

def std_thread(name):
    std = Student(name)
    # 把std放到全局变量global_dict中：
    global_dict[threading.current_thread()] = std
    do_task_1()
    do_task_2()

def do_task_1():
    # 不传入std，而是根据当前线程查找：
    std = global_dict[threading.current_thread()]
    print(f'task1:{std} ,name:{std.name}')

def do_task_2():
    # 任何函数都可以查找出当前线程的std变量：
    std = global_dict[threading.current_thread()]
    print(f'task2:{std} ,name:{std.name}')

std_thread('Zhang Ming')
std_thread('Zhu Yuanzhang')