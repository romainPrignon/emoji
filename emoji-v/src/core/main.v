module core

import net.http
import json

struct Result {
	text string [json: character]
    group string [json: subGroup]
}

fn do_query(word string) ?http.Response {
    access_key := 'c19560f67ed78510d1fa453f5609665c9538934d'

    return http.get('https://emoji-api.com/emojis?search=$word&access_key=$access_key')
}

// should be []Result | None
fn parse_json(response ?http.Response) []Result {
    res := json.decode([]Result, response.text) or {return []} // should return none

    return res
}

// There should be something preventing from using [0].text
fn filter_best_emoji(results []Result) string {
    return results.filter(it.group == 'emotion')[0].text
}

// should take a ?string and check that
pub fn run(word string) string {
    res := filter_best_emoji(parse_json(do_query(word)))
    return res
}