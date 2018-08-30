import {AxiosResponse, AxiosInstance} from 'axios'

interface Results {
    results: Array<Result>
}
interface Result {
    text: string
    score: number
}

export default class Core {
    private http_client: AxiosInstance
    
    constructor(axios: AxiosInstance) {
        this.http_client = axios
    }
    
    private async do_query(word: string): Promise<AxiosResponse<Results>> {
        return this.http_client.get<Results>('http://emoji.getdango.com/api/emoji', {
            params: {
                q: word
            }})
    }

    private async parse_json(response: Promise<AxiosResponse<Results>>): Promise<Array<Result>> {
        return response.then((res) => res.data.results)
    }
    
    private async filter_best_emoji (results: Promise<Array<Result>>): Promise<string> {
        return results.then(r => r[0].text)
    }

    public async run (word: string): Promise<string> {
        if (!word) throw new Error('undefined_word_error')

        return this.filter_best_emoji(this.parse_json(this.do_query(word)))
    }
} 