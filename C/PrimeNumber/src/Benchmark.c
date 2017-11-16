#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int isPrime(unsigned long p, unsigned long *primes){
	long sqrtPrime= (long)sqrt(p);
	int i;
	for(i=0;primes[i]<=sqrtPrime;i++)
		if(p%primes[i]==0) return 0;
	return 1;
}

unsigned long nextPrime(unsigned long prev, unsigned long *primes){
	while(!isPrime(prev+=2, primes));
	return prev;
}

unsigned long nthPrime(int nth, unsigned long *primes, int curIdx){
	if(primes[0] == 2 && primes[1] == 3){
		if(nth>=curIdx){
			primes[curIdx+1] = nextPrime(primes[curIdx], primes);
			return nthPrime(nth, primes, curIdx+1);
		}else return primes[nth-1];
	}
	else{
		primes[0] = 2; primes[1] = 3;
		if(nth<=2) return primes[nth-1];
		return nthPrime(nth, primes, 1);
	}
}

main(){
	int nth = 10000000;
	unsigned long *primes = (unsigned long *)malloc(nth * sizeof(unsigned long));
	unsigned long nthPrimeNumber = nthPrime(nth, primes, -1);
	printf("%dth Prime Number: %ld\n", nth, nthPrimeNumber);
	free(primes);
}
