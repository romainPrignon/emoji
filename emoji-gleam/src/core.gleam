import gleam/io
import gleam/http/request
import gleam/http/response.{type Response}
import gleam/httpc
import gleam/result
import gleam/string
import gleam/json
import gleam/dynamic/decode

fn do_query(word: String) {
    let url = "https://emoji-api.com/emojis?access_key=c19560f67ed78510d1fa453f5609665c9538934d&search="
        |> string.append(word)

    let assert Ok(req) = request.to(url)
    let assert Ok(res) = httpc.send(req)
    io.debug(res.body)
    res
}

fn parse_json(res: Response(String)) {
    let emoji_decoder = {
        use emojis <- decode.list(decode.dict("character", decode.string))
        decode.success(emojis)
    }
    json.parse(from: res.body, using: emoji_decoder)
}

pub fn run(name: String) {
    let result = do_query("love")
}