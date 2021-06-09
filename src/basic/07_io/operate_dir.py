# -*- coding=utf-8 -*-

import os
import logging

logging.basicConfig(level=logging.NOTSET)


def replace_whitespace(dir):
    '''
    递归替换空白字符
    :param dir: 目录
    :return: 无
    '''
    for file_dir in os.listdir(dir):
        new_name = get_new_name(file_dir)
        print(f"开始处理: {file_dir}  ==>  {new_name}")
        old_path = os.path.join(dir, file_dir)
        new_path = os.path.join(dir, new_name)
        if file_dir != new_name:
            logging.info(f"改名: {file_dir}  ==> {new_name}")
            os.rename(old_path, new_path)
        if os.path.isdir(new_path):
            print(f'递归目录{new_path}')
            replace_whitespace(new_path)


def get_new_name(old_name):
    '''
    替换异常字符后取得新字符
    :param old_name:
    :return:
    '''
    new_name = old_name
    if ' ' in old_name:
        new_name = new_name.replace(' ', '_')
    if ' ' in old_name:
        new_name = new_name.replace('：', '-')
    if ' ' in old_name:
        new_name = new_name.replace('/', '_')
    if ' ' in old_name:
        new_name = new_name.replace('——', '-')
    return new_name


def gci(filepath):
    '''
    递归目录
    :param filepath:
    :return:
    '''
    for file in os.listdir(filepath):
        fi_d = os.path.join(filepath, file)
        if os.path.isdir(fi_d):
            gci(fi_d)
        else:
            logging.info('文件:' + os.path.join(filepath, file))


if __name__ == "__main__":
    op_dir = r'F:\src_sfyh_ai\aipath2\dl'
    # logging.info(f'遍历目录:{op_dir}')
    # gci(op_dir)
    logging.info(f'递归替换目录中的空格:{op_dir}')
    replace_whitespace(op_dir)
