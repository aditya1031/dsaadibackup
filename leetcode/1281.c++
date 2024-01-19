// aditya kumar
// 21bcs9520
/*Given an integer number n, return the difference between the product of its digits and the sum of its digits. */
#include <iostream>
using namespace std;
int main()
{

    int n, digit, sum = 0, product = 1, r = 10;
    int ans;
    cin >> n;
    while (n != 0)
    {
        digit = n % r;
        sum = sum + digit;
        product = product * digit;
        n = n / 10;
    }

    ans = product - sum;
cout<<ans;
    return ans;
}