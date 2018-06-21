def estPalindrome(texte):
    debut = 0
    fin = len(texte) - 1
    while debut < fin:
        if texte[debut] != texte[fin]:
            return False
        debut += 1
        fin -=1
    return True

print("'kayak' palindrome ? ", estPalindrome("kayak"))
print("'radar' palindrome ? ", estPalindrome("radar"))
print("'anna' palindrome ? ", estPalindrome("anna"))
print("'vincent' palindrome ? ", estPalindrome("vincent"))
print("'experte' palindrome ? ", estPalindrome("experte"))
print("'aladdin' palindrome ? ", estPalindrome("aladdin"))