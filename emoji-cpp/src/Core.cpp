#include <string>
#include <optional>
#include <vector>

#include "httplib.h"
#include "json.h"

using namespace std;
using json = nlohmann::json;

namespace core {
    // begin mock
    string mock = "{\"results\":[{\"text\":\"❤️\",\"score\":0.03845089674},{\"text\":\"♥️\",\"score\":0.029323654249},{\"text\":\"💕\",\"score\":0.023672752082},{\"text\":\"💙\",\"score\":0.018879935145},{\"text\":\"😍\",\"score\":0.017967805266}]}";
    // end mock
    
    class Result {
        public:
            Result(string text, float score) {
                _text = text;
                _score = score;
            }

            string getText() {
                return _text;
            }

            float getScore() {
                return _score;
            }
        
        protected: 
            string _text;
            float _score;
    };

    class Core {
        private:
            optional<httplib::Response> do_query(string word)
            {
                httplib::Response res = *new httplib::Response();
                res.status = 500;
                res.body = mock;

                if (res.status == 200) {
                    return res;
                }
                
                return nullopt;
            }

            optional<vector<Result>> parse_json(optional<httplib::Response> res)
            {
                if (res) {
                    json body = json::parse(res->body);
                    auto json_results = body.at("results");

                    vector<Result> results;
                    for (json::iterator it = json_results.begin(); it != json_results.end(); ++it) {
                        
                        string text = it.value().at("text");
                        float score = it.value().at("score");
                        Result result = Result(text, score);

                        results.push_back(result);
                    }
                    
                    return results;
                }
                
                return nullopt;
            }

            optional<string> filter_best_emoji(optional<vector<Result>> opt_results) 
            {
                if (opt_results) {
                    vector<Result> results = opt_results.value();

                    // same as: return results[0].getText();
                    auto max_score = [](Result acc, Result result) {
                        return result.getScore() > acc.getScore() ? result : acc;
                    };

                    Result result = accumulate(results.begin(), results.end(), results[0], max_score);

                    return result.getText();    
                }

                return nullopt;
            }

        public:
            optional<string> run(string word)
            {
                return filter_best_emoji(parse_json(do_query(word)));
            }
    };
}