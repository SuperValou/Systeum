#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>

// pour compiler ce programme : cc pid.c -o pid
// pour executer ce programme ./pid
  

main(){

  pid_t pidFils= fork();
  if (pidFils!=0){
    /* ------------ code du p�re ----------------- */
    printf("je suis le pere, mon numero est %d",getpid()); 
    printf(", celui de mon fils est %d",pidFils);
    printf(", tandis que celui de mon pere est %d\n", getppid());
    sleep(10);
  }

  else{
    /* ------------ code du fils ----------------- */
    sleep(1);
    printf("je suis le fils, mon numero est %d",getpid());
    printf(", celui de mon pere est %d", getppid());
    printf(", tandis que celui de mon grand-pere c'est, ben, chaipo.\n");
    sleep(10);
    }
}
  
