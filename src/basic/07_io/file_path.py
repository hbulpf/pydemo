import os


def traverse_dir(file_dir):
    for path, dir, file in os.walk(file_dir):
        for name in file:
            print(dir, path, '==>', name)


def query_file_name():
    key = input('请输入您想要查询的关键字\n')

    for path, dir, file in os.walk('.'):
        k = False
        for name in file:
            if key in name:
                print(dir, path, '==>', name)
                k = True
        if k:
            print('-' * 50)


if __name__ == '__main__':
    traverse_dir('.')
