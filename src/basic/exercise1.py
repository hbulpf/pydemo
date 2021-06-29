#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Feb 18 11:52:32 2019

@author: foreverlpficloud.com
"""

def is_leap(year):
    leap = False
    
    # Write your logic here
    if(year % 400 == 0 or (year % 4 == 0 and year % 100 != 0)):
        leap = True
        
    return leap

year = int(input())
print(is_leap(year))