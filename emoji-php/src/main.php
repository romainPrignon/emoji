<?php

require __DIR__ . '/../vendor/autoload.php';

use \Emoji\Cli;
use \Emoji\Core;
use \GuzzleHttp\Client as GuzzleClient;

$client = new GuzzleClient();

$core = new Core($client);

$cli = new Cli($core);

$cli->run($argv);
