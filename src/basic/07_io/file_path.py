import os
import sys


def traverse_dir(file_dir):
    for path, dir, files in os.walk(file_dir):
        for name in files:
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


def batch_rename_file(dir_path):
    """
    批量重命名文件
    """
    old_names = os.listdir(dir_path)
    for old_name in old_names:
        if old_name != sys.argv[0]:  # 代码本身文件路径，防止脚本文件放在path路径下时，被一起重命名
            if "_" in old_name:
                parts = old_name.split("_")
                q_num = '0' * (4 - len(parts[0][1:])) + parts[0][1:]
                prefix = q_num + '_' + parts[0][0]
                new_name = prefix + '_' + parts[1]
                print(os.path.join(dir_path, old_name), " ===> ", os.path.join(dir_path, new_name))
                os.rename(os.path.join(dir_path, old_name), os.path.join(dir_path, new_name))

def generate_dir(file_dir):
    for path, dir, files in os.walk(file_dir):
        for name in files:
            print("[{0}](docs/其他/docsify/docs-zh/{0})".format(name))

if __name__ == '__main__':
    traverse_dir('.')
    # batch_rename_file(r'F:\src_sfyh\LeetcodeEveryday\code_python\solution')
    generate_dir(r'E:\src_ui\web_ui_notes\docs\其他\docsify\docs-zh')
