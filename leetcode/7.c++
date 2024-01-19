// aditya kumar
// 21bcs9520
/*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.*/
// aditya kumar
// 21bcs9520

#include <iostream>
#include <stdio.h>
#include<limits.h>
using namespace std;
int main()
{

    int ans = 0, x;
    cin >> x;
    while (x != 0)
    {

        int digit = x % 10;
        if(ans>(INT_MAX/10)||ans<(INT_MIN/10))
        {
         return 0;
        }
        ans = (ans * 10) + digit;
        x = x / 10;
    }
    cout << ans;
};