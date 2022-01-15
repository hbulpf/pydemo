from multiprocessing import Pool
import os,time,random

def long_time_task(name):
    with open('temp.txt','a') as f:
        f.write('Run task %s (%s)...\n' % (name,os.getpid()))
    start = time.time()
    # 0到3之间随机
    time.sleep(random.random() * 3)
    end = time.time()
    with open('temp.txt','a') as f:
        f.write('Task %s runs %0.2f seconds.\n' % (name,(end - start)))


if __name__ == '__main__':
    with open('temp.txt','w') as f:
        f.write('Parent process %s.\n' % os.getpid())

    p = Pool(4)
    for i in range(5):
        p.apply_async(long_time_task,args=(i,))
    with open('temp.txt','a') as f:
        f.write('Waiting for all subprocesses done...\n')
    p.close()
    p.join()
    with open('temp.txt','a') as f:
        f.write('All subprocess done.')