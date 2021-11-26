#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2021/8/31 00:02
@Author: RunAtWorld
@File: test_dfs.py
"""
import unittest

from dfs import DFS


class TestDfs(unittest.TestCase):
    def setUp(self) -> None:
        self.instance = DFS()