open Js
open Belt

module Option = Belt.Option

module Core = () => {

    // sring out optiob<string ?>
    let run = (word: option<'string>): Promise.t<'string> => {
        Js.log("run")
        Promise.resolve(word->Option.getWithDefault("lol"))
    }

}