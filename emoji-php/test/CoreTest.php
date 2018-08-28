<?php
declare(strict_types=1);

use PHPUnit\Framework\TestCase;

use Emoji\Core;
use GuzzleHttp\Client as GuzzleClient;
use GuzzleHttp\Psr7\Response;

final class CoreTest extends TestCase
{
    public function testShouldReturnAnEmoji()
    {
        // given
        $word = 'love';
        $body = json_encode([
            'results' => [
                [
                    'text' => '<3',
                    'score' => 1
                ],
                [
                    'text' => ':(',
                    'score' => 0
                ]
            ]
        ]);

        // mock
        $clientMock = $this->createMock(GuzzleClient::class);
        $clientMock->method('request')
            ->willReturn(new Response(200, [], $body));

        // when
        $core = new Core($clientMock);
        $output = $core->run($word);

        // then
        $this->assertEquals($output, '<3');
    }

    public function testShouldReturnAnError()
    {
        // given
        $word = 'love';

        // mock
        $clientMock = $this->createMock(GuzzleClient::class);
        $clientMock->method('request')
            ->will($this->throwException(new Exception('NetwordError')));

        // when
        $core = new Core($clientMock);
        $output = $core->run($word);

        // then
        $this->assertEquals($output, ':boom:');
    }
}
