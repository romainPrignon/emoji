#include <iostream>
#include <string>
#include <optional>

// so hacky :(
#ifndef CORE
#define CORE
#include "Core.cpp"
#endif

using namespace std;

namespace cli {
    class Cli
    {
        protected:
            core::Core core;
        
        public:
            Cli(core::Core core)
            {
                this->core = core;
            }

            string stdin(const char* argv[])
            {
                if (argv[1]) {
                    return argv[1];
                }

                exit(EXIT_FAILURE);
            }

            optional<string> main(string word)
            {
                return this->core.run(word);
            }

            void stdout(optional<string> output)
            {
                if (output) {
                    cout << output.value();

                    exit(EXIT_SUCCESS);
                }

                exit(EXIT_FAILURE);
            }

            void run(const char* argv[])
            {
                return this->stdout(this->main((this->stdin(argv))));
            }
    };
}
