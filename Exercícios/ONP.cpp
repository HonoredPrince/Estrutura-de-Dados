#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main(){
    int input;
    cin >> input;
    string expressao[input];
    string resultado[input];

    for(int i = 0; i < input; ++i)
    {
        cin >> expressao[i];
    }

    for(int i = 0; i < input; ++i)
    {
            stack<char> c;
            //Algoritmo do Djikstra(shunting-yard) para ser feita a notação polonesa
            for(string::iterator it = expressao[i].begin(); it != expressao[i].end(); ++it)
            {
                if(*it == '^' || *it == '(')
                {
                    c.push(*it);
                }else
                if(*it == '*' || *it == '/')
                {
                    if(c.top() != '^');
                        c.push(*it);
                }else
                if(*it == '+' || *it == '-')
                {
                    if(c.top() != '^' && c.top() != '*' && c.top() != '/')
                        c.push(*it);

                }else
                if(*it == ')')
                {
                    while (c.top() != '(')
                    {
                        resultado[i] += c.top();
                        c.pop();
                    }
                    c.pop();
                }else{
                    resultado[i] += *it;
                }
            }
            while(!c.empty())
            {
                resultado[i] += c.top();
                c.pop();
            }
    }

    for(int i = 0; i < input; ++i)
    {
        cout << resultado[i];
        if(i != input - 1)
        {
            cout << endl;
        }
    }

    return 0;
}
