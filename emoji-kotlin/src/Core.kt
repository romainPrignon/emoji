fun do_query(word: string): Results {
        return this.http_client.get<Results>('http://emoji.getdango.com/api/emoji', {
            params: {
                q: word
            }})
    }

fun run (word: string): string {
    if (!word) throw Exception("there is no word")

    return filter_best_emoji(parse_json(do_query(word)))
}