import random

import pyautogui as pg

import time

options=('a','b','c','d')

time.sleep(10)

for i in range(500):
    a= random.choice(options)
    pg.write(a)
    pg.press('enter')
