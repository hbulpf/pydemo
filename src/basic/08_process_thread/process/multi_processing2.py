from multiprocessing import Process
import os,time

# 子进程要执行的代码
def run_proc(name):
    for i in range(10):
        time.sleep(1)
        print(f'Run child process {name}: {os.getpid()}-', i)

if __name__=='__main__':
    print(f'Parent process: {os.getpid()}')
    p = Process(target=run_proc, args=('test',))
    print('Child process will start.')
    p.start()
    for i in range(10):
        time.sleep(1)
        print(f'Run Parent process: {os.getpid()}-', i)
    p.join()
    print('Child process end.')