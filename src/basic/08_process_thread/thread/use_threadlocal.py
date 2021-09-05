import threading
    
# 创建全局ThreadLocal对象:
local_school = threading.local()

def process_student():
    # 获取当前线程关联的student:
    std = local_school.student
    grade = local_school.grade
    print('Hello, %s:grade %s (in %s)\n' % (std, grade, threading.current_thread().name))

def process_thread(name,grade):
    # 绑定ThreadLocal的student:
    local_school.student = name
    local_school.grade = grade
    process_student()

t1 = threading.Thread(target= process_thread, args=('Alice','2'), name='Thread-A')
t2 = threading.Thread(target= process_thread, args=('Bob','3'), name='Thread-B')
t1.start()
t2.start()
t1.join()
t2.join()