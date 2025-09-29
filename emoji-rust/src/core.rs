// extern crate hyper;
// extern crate http;

// use hyper::Client;
// use hyper::rt::{Future};
// use http::{Response};

// // fn do_query(word: String) -> impl Future<Item=(), Error=hyper::Error> { // WTF &'static str ??
// //     let http_client = Client::new();

// //     let url = "http://emoji.getdango.com/api/emoji".parse().unwrap();
    
    
// //     return http_client
// //         .get(url)
// //         .map(|res| {
// //             println!("Response: {}", "ici");
// //             println!("Response: {}", res.status());
// //         })
// // }

// fn do_query(word: &str) -> Response {
//     let http_client = Client::new();
    
//     let url = "http://emoji.getdango.com/api/emoji".parse().unwrap();
    
//     return http_client
//         .get(url)
//         // .and_then(|res| {
//         //     return res.body().concat()
//         // })
//         // .map(|body| {
//         //     return String::from_utf8(body)
//         // })
//         .map_err(|err| {
//             String::from("there was an error")
//         })
// }

// fn filter_best_emoji(response: Response) -> () {
//     let body = response.body().unwrap;
//     println!("{}", body);

//     return ()
// }

// fn emoji(word: &str) -> &str {
//     let res = filter_best_emoji(do_query(word));
//     println!("{}", res);
//     // return filter_best_emoji(res)
    
//     if word == "love" {
//         return "❤";
//     } else {
//         return "the emoji for the word";
//     }
// }

// fn main() {
//     let emo = emoji("love");
//     println!("{}", emo);
// }