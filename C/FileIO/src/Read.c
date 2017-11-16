#include <stdio.h>

main(){
	FILE *f;
	f = fopen("test.txt", "r");
	char c;
	unsigned long d = 0;
	while(!feof(f)) {
		c = fgetc(f);
		d++;
	}
	fclose(f);
	printf("Size: %dByte",d);
}
