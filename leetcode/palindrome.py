class Solution:
    def palindrome(a):
        s = 0
        n = a
        while n!=0:
            r = n%10
            n = (int)(n/10)
            s = (s*10)+r
        if s==a:
            print('%s number is palindrome'%a)
        else:
            print('%s number is not a palindrome'%a)
n = Solution
n.palindrome(121)

