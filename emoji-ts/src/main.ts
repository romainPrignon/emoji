import Core from './Core'
import axios from 'axios'

const argv = process.argv.slice(2)
const core = new Core(axios)

core.run(argv[0])
    .then(console.log)