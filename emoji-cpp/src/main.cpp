// so hacky :(
#ifndef CORE
#define CORE
#include "Core.cpp"
#endif

#include "Cli.cpp"

using namespace std;

int main(int argc, const char* argv[])
{
    core::Core core = core::Core();
    cli::Cli cli = cli::Cli(core);
    
    cli.run(argv);
}
