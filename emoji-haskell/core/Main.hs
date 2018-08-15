module Core(emoji) where

import Network  

-- doQuery :: String -> IO ()
-- doQuery = do
    -- res <- simpleHTTP (getRequest "http://emoji.getdango.com/api/emoji")
    -- putStrLn res

-- filterBestEmoji :: HTTPResponse -> String


emoji :: String -> String
emoji "love" = "❤"
emoji word =
    "the emoji for " ++ word
    
-- emoji "foo" = throw

-- the following are the same
main :: IO ()
main =
    putStrLn $ emoji "smthg"
    putStrLn (emoji "smthg")