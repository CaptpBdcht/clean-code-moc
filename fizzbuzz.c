#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>     
#include <string.h>     

bool isuserInputAnInt(char *userInput) {
     for (int i = 0; i < strlen(userInput); i++ ) {
        if (userInput[i] < 0) {
            printf("Cannot fizzbuzz negative numbers \n");
            return false; 
        }
        if ( ! isdigit( userInput[i] ) ) {
            printf("Cannot fizzbuzz non digit values \n");
            return false;
        }
     }

    return true;
} 

bool isUserInputValid(char* userInput) {
    if (isuserInputAnInt(userInput)) {
        return true;
    }

    return false;
}

int convertIntArrayToInt(int *intArray) {
    int intNumber = 0;
    
    for (int i = 0; i < sizeof(intArray); i++)
        intNumber = 10 * intNumber + intArray[i];
        
    return intNumber;
}

void fizzbuzzCalculation(char *fizzbuzzUserNumber) {
    int fizzbuzzIntArray[10];
    int fizzbuzzFinalNumber;

    for (int i = 0; i < strlen(fizzbuzzUserNumber); i++) {
        fizzbuzzIntArray[i] = atoi(&fizzbuzzUserNumber[i]);
    }

    fizzbuzzFinalNumber = convertIntArrayToInt(fizzbuzzIntArray);

    printf("%i", fizzbuzzFinalNumber);
}

int main() {
    char fizzbuzzUserNumber[10];

    printf("fizzbuzz \n");
    scanf( "%[^\n]", fizzbuzzUserNumber);

    if (isUserInputValid(fizzbuzzUserNumber)){
        fizzbuzzCalculation(fizzbuzzUserNumber);
    }
}
