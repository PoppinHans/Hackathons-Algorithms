#include <iostream>

using namespace std;

struct S {
	unsigned char num1Bits;
	unsigned char trailingZeros; 
};

void count (unsigned int i, S *p) {
	int ones = 0;
	int zeros = 0;
	bool sawOne = false;
	for (int j = 0; j < 32; ++j) {
		int cur = 1 & (i >> j);
		if (cur) {
			sawOne = true;
			++ones;
		} else if (!sawOne) {
			++zeros;
		}
	}
	p -> num1Bits = '0' + ones;
	p -> trailingZeros = '0' + zeros;
}

int main() {
	unsigned int i = 5;
	S st;
	S* p = &st;
	count(i, p);
	cout << st.num1Bits << " " << st.trailingZeros << endl;
}
