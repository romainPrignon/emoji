let add (x y) = x + y

let () =
  let result = Math.add 2 3;
  print_endline (string_of_int result);