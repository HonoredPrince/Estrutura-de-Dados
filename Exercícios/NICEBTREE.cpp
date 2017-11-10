#include <iostream>
#include <string>

class Node
{
	public:
		char c;
		Node *l, *r;
};

class Tree
{
	public:
		Node *rt;

		std::string ipt;
		int indx;

		Tree(std::string s)
		{
			ipt = s;
			indx = 0;

			Node *n = new Node();
			rt = n;

			rt->c = ipt[indx];

			if (rt->c == 'l')
            {
				rt->l = nullptr;
				rt->r = nullptr;
			}
			else
			{
				rt->l = add(rt, ipt[++indx]);
				rt->r = add(rt, ipt[++indx]);
			}
		}

		Node *add(Node *p, char cnt) {
			Node *n = new Node();
			n->c = cnt;

			if (cnt == 'l') {
				n->l = nullptr;
				n->r = nullptr;
			} else {
				n->l = add(n, ipt[++indx]);
				n->r = add(n, ipt[++indx]);
			}

			return n;
		}

		int cDepth() {
			return (depth(rt) - 1);
		}

		int depth(Node *n) {
			if (n == nullptr) {
				return 0;
			}

			int l = depth(n->l);
			int r = depth(n->r);

			if (l > r)
				return ++l;
			else
				return ++r;
		}
};

int main() {
	int lines;
	std::cin >> lines;
	std::string ipt;

	// Warning: memory leak
	for (int i = 0; i < lines; ++i) {
		std::cin >> ipt;
		Tree *tree = new Tree(ipt);
		std::cout << tree->cDepth();

		if (i != lines-1)
		{
			std::cout << '\n';
		}
	}

	return 0;
}
