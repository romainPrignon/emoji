open Belt
open Core




let argv = Array.slice(~offset=2, ~len=Array.length(Sys.argv), Sys.argv)
let args = Array.get(argv, 0)
Js.log(args)


//import axios from 'axios'


// new Core
module Core = Core()

Core.run(args)

//core.run(args)
//   .then(console.log)