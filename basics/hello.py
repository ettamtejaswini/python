import sys
def main():
    a = input('Enter your name')
    print ('\n'+a)
    print(sys.stdin.readline())
    print ('\nHello world!! Welcome to python world\n'),
    print (sys.argv[0])
    iterate()
def iterate():
    b =[55]
    print(len(b))
    for i in range(0,5):
        print('hello',i)
        b[0] = 'asd'
        #b.append(input('enter a vowel'))
        """jjjjjjjjjjjjjjjj
ghhhhhhhhhhhhhh
"""
    for i in range(0,5):
        print(b[0])
if __name__=="__main__":
    main()
