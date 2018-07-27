extern crate hyper;

use hyper::Client;
use hyper::rt::{Future};

fn do_query(word: String) -> impl Future<Item=(), Error=hyper::Error> { // WTF &'static str ??
    let http_client = Client::new();

    let url = "http://emoji.getdango.com/api/emoji".parse().unwrap();
    
    
    return http_client
        .get(url)
        .map(|res| {
            println!("Response: {}", "ici");
            println!("Response: {}", res.status());
        })
    
    
    
    
    // if word == "love" {
    //     return "❤"
    // } else {
    //     return "the emoji for the word"
    // }
}

// fn filter_best_emoji() {}

fn emoji(word: String) -> () {
    do_query(word)

    // let res = do_query(word);
    //println!("{}", res.status());
}

fn main() {
    emoji(String::from("love"))
}