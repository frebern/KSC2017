#include <stdio.h>

main(){
	FILE *f;
	f = fopen("test.txt","w");
	unsigned long GB = 1*1024*1024*1024;
	while(GB--)
		fputc('A',f);
	fputc(EOF,f);
	fclose(f);
}
