interface Result {
    character: string
}

type Fetch = typeof fetch

export default class Core {
    private http_client: Fetch
    
    constructor() {
        this.http_client = fetch
    }
    
    private async do_query(word: string): Promise<Response> {
        const access_key = 'c19560f67ed78510d1fa453f5609665c9538934d'
        return this.http_client(`https://emoji-api.com/emojis?access_key=${access_key}&search=${word}`)
    }

    private async parse_json(response: Promise<Response>): Promise<Array<Result>> {
        return response
            .then((res) => res.json())
    }
    
    private async filter_best_emoji (results: Promise<Array<Result>>): Promise<string> {
        return results.then(r => r[0].character)
    }

    public async run (word: string): Promise<string> {
        if (!word) throw new Error('undefined_word_error')

        return this.filter_best_emoji(this.parse_json(this.do_query(word)))
    }
} 