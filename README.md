# BTC-Converter
BTC to USD converter

Simple converter which takes HTTP POST request with value parameters and returns exchanged value response.
All rates are taken from coinbase.com and updates when you send your reques

## How to use

To convert btc -> usd you can send request on
``` 
0.0.0.0:8080/convert/btc?value=<your value>
```
To convert usd -> btc you can send request on
``` 
0.0.0.0:8080/convert/usd?value=<your value>
```


## How to run with docker
Clone repository:
``` console
$ git clone https://github.com/KoTTiG/BTC-Converter.git
```
CD into app folder:
``` console
$ cd BTC-Converter
```
Build docker image:
``` console
$ docker build -t BtcConverter
```
Run docker image:
``` console
$ docker run -p 8080:8080 BtcConverter
```

## Lisense
We're [Apache ](./LICENSE) licensed.