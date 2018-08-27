<?php
declare(strict_types = 1);

namespace Emoji;

use Emoji\Core as Core;

class Cli
{
    public function __construct(Core $core)
    {
        $this->core = $core;
    }

    public function stdin(array $args): ?string
    {
        return $args[1] ?? null;
    }

    public function main(string $word): string
    {
        return $this->core->run($word);
    }

    public function stdout(string $output): void
    {
        printf($output);
    }

    public function run(array $args)
    {
        return $this->stdout($this->main(($this->stdin($args))));
    }
}
