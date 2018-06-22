import random

def bubble_sort(tab):
    if len(tab) < 2:
        return tab
    pos = 0
    pas = 0
    while pos < len(tab) - 1:
        pas += 1
        if tab[pos] <= tab[pos + 1]:
            pos += 1
        else:
            v = tab[pos]
            tab[pos] = tab[pos + 1]
            tab[pos + 1] = v
            pos -= 1
            if pos < 0:
                pos = 0
    return (pas,tab)       

tab = [2, 10, 5, 15, 3, 4, 9, 1]
print(tab)
print(bubble_sort(tab))





