<?php
declare(strict_types = 1);

namespace Emoji;

use GuzzleHttp\Client;

interface ResultInterface {
    public function getText(): string;
    public function getScore(): float;
}

class Result implements ResultInterface
{
    public function __construct (array $data)
    {
        foreach ($data as $key => $value) $this->{$key} = $value;
    }

    public function getText(): string
    {
        return $this->text;
    }

    public function getScore(): float
    {
        return $this->score;
    }
}

class Core
{
    private $client;

    public function __construct(\GuzzleHttp\Client $client)
    {
        $this->client = $client;
    }

    private function do_query(string $word): ?\GuzzleHttp\Psr7\Response
    {
        try {
            return $this->client->request('GET', 'http://emoji.getdango.com/api/emoji', [
                'query' => ['q' => $word]
            ]);
        } catch (\Exception $e) {
            return null;
        }
    }

    private function parse_json(?\GuzzleHttp\Psr7\Response $response): ?array
    {
        if (!$response) return null;

        $body = json_decode($response->getBody()->getContents(), true);
        $results = $body['results'];

        $getResult = function (array $array): Result
        {
            return new Result($array);
        };

        $results = array_map($getResult, $results);

        return $results;
    }

    private function filter_best_emoji(?array $results): ?string
    {
        if (!$results) return null;

        $maxScore = function ($acc, $result)
        {
            if ($result->getScore() > $acc->getScore()) {
                return $result;
            } else {
                return $acc;
            }
        };

        $result = array_reduce($results, $maxScore, $results[0]);

        return $result->getText();
    }

    public function run(string $word): string
    {
        if (empty($word)) {
            throw new Exception("UndefinedWordError");
        }

        $res = $this->filter_best_emoji($this->parse_json($this->do_query($word)));

        return $res ?? ':boom:';
    }
}
