#include "static-link.h"

int* toto (char* id) {
    return ((int*)id);
}

int titi() {
    return 42;
}

