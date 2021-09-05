open System

let run (word: string): string option = 
    try
        printfn "call core with %s" word
        Some("💌")
    with
        | (ex: exn) -> None
                
let stdin (argv: string array): string = 
    argv.[0]

let stdout (res: string option): unit = 
    // printfn "%s" res.Value marche aussi
    if res.IsSome then
        printfn "%s" res.Value
    else
        printfn "Something went wrong :("

[<EntryPoint>]
let main (argv: string array) =
    stdin(argv)
        |> run
        |> stdout
    0