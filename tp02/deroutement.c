#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <signal.h>
#include <sys/types.h>
#include <setjmp.h>


int i = 0;
int j = 0;
jmp_buf env;
struct sigaction action;

void handler(int sig)
{
  printf("div 0\n");
  i=1;
  j=1;
  longjmp(env,0);  // A decommenter
}

int main (int argc, char * argv[])
{

  //D�finition du handler
  action.sa_handler=handler;
  signal(SIGFPE,(*handler)); // signal lev� quand div par z�ro -> execute handler
  setjmp(env);    // fonctionne comme un GOTO
  printf("deb i=%d j=%d\n", i ,j);
  j = 12/i;
  printf("fin i=%d j=%d\n", i, j);
  exit(0);
}
