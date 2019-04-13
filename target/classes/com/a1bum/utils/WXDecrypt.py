import requests
import json
import sys


def queryID(jscode):
    url = 'https://api.weixin.qq.com/sns/jscode2session?appid=wxf510a2262ffb3945' \
        + '&secret=7895cb72af5d703d2db983808710618c' \
        + '&js_code=' + jscode + '&grant_type=authorization_code'
    res = requests.get(url)
    data = json.loads(res.text)
    print(data.get('openid'))


if __name__ == "__main__":
    jscode = str(sys.argv[1])
    queryID(jscode)