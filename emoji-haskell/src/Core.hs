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

-- main :: IO ()
-- main = -- the following are the same
    -- putStrLn $ emoji "smthg"
    -- putStrLn (emoji "smthg")