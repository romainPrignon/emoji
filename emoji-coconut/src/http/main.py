import requests
from ..core.main import Core

from flask import (Flask, json)
app = Flask(__name__)

@app.route("/emoji/<word>")
def emoji(word):
    core = Core(requests)
    
    try:
        res = core.run(word)

        return json.dumps({
            "word": word,
            "emoji": res
        })
    except Exception as e:
        if str(e) == "undefined_word_error": return "There is no emoji for foo"
        else: return "[Something broke !]" + str(e)
