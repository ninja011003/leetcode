import random

import pyautogui as pg

import time

options=()

time.sleep(10)

for i in range(50):
    a= random.choice(options)
    pg.write(' '+a)
    pg.press('enter')
