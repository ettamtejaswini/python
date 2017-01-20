import sys
def main():
    a = [2,3,4,5]
    target = 6
    sum = 0
    for i in range (0,len(a)):
        if ((i+1) < len(a)):
            sum = a[i]+a[i+1]
            if( sum == target):
                print('output:',a[i],a[i+1])
                break

if __name__=="__main__":
    main()
