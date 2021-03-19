import threading, multiprocessing

def loop():
    x = 0
    while True:
        x = x ^ 1
        print(f'x={x}')

for i in range(multiprocessing.cpu_count()):
    t = threading.Thread(target=loop)
    t.start()