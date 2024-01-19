// aditya kumar
// 21bcs9520
/*Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the */
#include <iostream>
using namespace std;
int main()
{
    long int n, ans = 0, digit;
    cin>>n;
    while (n != 0)
    {
        
        if (n&1)  //checks the last bit is one or not.
        {
            ans++;
        }

        n = n>>1;  //left shift
    }

    cout << ans;

    return 0;
}