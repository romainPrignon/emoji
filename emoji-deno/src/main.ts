import Core from './Core.ts'

const argv = Deno.args
const core = new Core()

core.run(argv[0])
    .then(console.log)